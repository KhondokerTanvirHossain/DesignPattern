package DesignPatterns.StructuralDesignPatterns.Facade.src;

import java.io.File;

// These are some of the classes of a complex 3rd-party video conversion framework.
class VideoFile {
    public VideoFile(String filename) {
        System.out.println("VideoFile created: " + filename);
    }
}

class OggCompressionCodec {
    public OggCompressionCodec() {
        System.out.println("OggCompressionCodec created");
    }
}

class MPEG4CompressionCodec {
    public MPEG4CompressionCodec() {
        System.out.println("MPEG4CompressionCodec created");
    }
}

class CodecFactory {
    public static Object extract(VideoFile file) {
        System.out.println("CodecFactory extracting codec");
        return new Object();
    }
}

class BitrateReader {
    public static Object read(String filename, Object sourceCodec) {
        System.out.println("BitrateReader reading file with codec");
        return new Object();
    }

    public static Object convert(Object buffer, Object destinationCodec) {
        System.out.println("BitrateReader converting bitrate");
        return new Object();
    }
}

class AudioMixer {
    public Object fix(Object result) {
        System.out.println("AudioMixer fixing audio");
        return new Object();
    }
}

// Facade class to hide the framework's complexity
class VideoConverter {
    public File convert(String filename, String format) {
        VideoFile file = new VideoFile(filename);
        Object sourceCodec = CodecFactory.extract(file);
        Object destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        Object buffer = BitrateReader.read(filename, sourceCodec);
        Object result = BitrateReader.convert(buffer, destinationCodec);
        result = (new AudioMixer()).fix(result);
        System.out.println("VideoConverter: conversion complete.");
        return new File("output." + format);
    }
}

// Application class
public class Main {
    public static void main(String[] args) {
        VideoConverter convertor = new VideoConverter();
        File mp4 = convertor.convert("funny-cats-video.ogg", "mp4");
        System.out.println("Saved file: " + mp4.getName());
    }
}