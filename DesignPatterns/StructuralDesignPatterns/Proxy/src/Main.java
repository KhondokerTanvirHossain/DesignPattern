package DesignPatterns.StructuralDesignPatterns.Proxy.src;

interface ThirdPartyYouTubeLib {
    void listVideos();
    void getVideoInfo(String id);
    void downloadVideo(String id);
}

class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {
    public void listVideos() {
        System.out.println("Sending an API request to YouTube.");
    }

    public void getVideoInfo(String id) {
        System.out.println("Getting metadata about some video.");
    }

    public void downloadVideo(String id) {
        System.out.println("Downloading a video file from YouTube.");
    }
}

class CachedYouTubeClass implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib service;
    private String listCache, videoCache;
    private boolean needReset;

    public CachedYouTubeClass(ThirdPartyYouTubeLib service) {
        this.service = service;
    }

    public void listVideos() {
        if (listCache == null || needReset) {
            listCache = "service.listVideos()";
            System.out.println("Caching video list.");
        }
        System.out.println("Returning cached video list.");
    }

    public void getVideoInfo(String id) {
        if (videoCache == null || needReset) {
            videoCache = "service.getVideoInfo(id)";
            System.out.println("Caching video info.");
        }
        System.out.println("Returning cached video info.");
    }

    public void downloadVideo(String id) {
        if (!"downloadExists(id)".equals(id) || needReset) {
            service.downloadVideo(id);
        }
    }
}

class YouTubeManager {
    protected ThirdPartyYouTubeLib service;

    public YouTubeManager(ThirdPartyYouTubeLib service) {
        this.service = service;
    }

    public void renderVideoPage(String id) {
        service.getVideoInfo(id);
        System.out.println("Rendering the video page.");
    }

    public void renderListPanel() {
        service.listVideos();
        System.out.println("Rendering the list of video thumbnails.");
    }

    public void reactOnUserInput() {
        renderVideoPage("videoId");
        renderListPanel();
    }
}

public class Main {
    public static void main(String[] args) {
        ThirdPartyYouTubeLib aYouTubeService = new ThirdPartyYouTubeClass();
        ThirdPartyYouTubeLib aYouTubeProxy = new CachedYouTubeClass(aYouTubeService);
        YouTubeManager manager = new YouTubeManager(aYouTubeProxy);
        manager.reactOnUserInput();
    }
}
