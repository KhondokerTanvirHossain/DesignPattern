package DesignPatterns.BehavioralDesignPatterns.Mediator.src;

interface Mediator {
    void notify(Component sender, String event);
}

class AuthenticationDialog implements Mediator {
    private String title;
    private Checkbox loginOrRegisterChkBx;
    private Textbox loginUsername, loginPassword;
    private Textbox registrationUsername, registrationPassword, registrationEmail;
    private Button okBtn, cancelBtn;

    public AuthenticationDialog() {
        this.loginOrRegisterChkBx = new Checkbox(this);
        this.loginUsername = new Textbox(this);
        this.loginPassword = new Textbox(this);
        this.registrationUsername = new Textbox(this);
        this.registrationPassword = new Textbox(this);
        this.registrationEmail = new Textbox(this);
        this.okBtn = new Button(this);
        this.cancelBtn = new Button(this);
    }

    private boolean findUser(Textbox username, Textbox password) {
        // This is a dummy implementation. In a real-world application, you would check the credentials against a database or other user store.
        return true;
    }

    public void notify(Component sender, String event) {
        if (sender.equals(loginOrRegisterChkBx) && event.equals("check")) {
            if (loginOrRegisterChkBx.checked) {
                title = "Log in";
                // Show login form components and hide registration form components.
                System.out.println("Showing login form components");
                System.out.println("Hiding registration form components");
            } else {
                title = "Register";
                // Show registration form components and hide login form components.
                System.out.println("Showing registration form components");
                System.out.println("Hiding login form components");
            }
        }

        if (sender.equals(okBtn) && event.equals("click")) {
            if (loginOrRegisterChkBx.checked) {
                // Try to find a user using login credentials.
                // If not found, show an error message above the login field.
                // Else, create a user account using data from the registration fields and log that user in.
                System.out.println("Trying to find a user using login credentials");
                boolean found = findUser(loginUsername, loginPassword);
                if (!found) {
                    System.out.println("User not found, showing an error message above the login field");
                } else {
                    System.out.println("Creating a user account using data from the registration fields");
                    System.out.println("Logging that user in");
                }
            }
        }
    }
}

class Component {
    protected Mediator dialog;

    public Component(Mediator dialog) {
        this.dialog = dialog;
    }

    public void click() {
        dialog.notify(this, "click");
    }

    public void keypress() {
        dialog.notify(this, "keypress");
    }
}

class Button extends Component {

    public Button(Mediator dialog) {
        super(dialog);
        //TODO Auto-generated constructor stub
    }
    // Button specific code...
}

class Textbox extends Component {
    private String text;

    public Textbox(Mediator dialog) {
        super(dialog);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}

class Checkbox extends Component {
    public Checkbox(Mediator dialog) {
        super(dialog);
        //TODO Auto-generated constructor stub
    }

    public boolean checked;

    public void check() {
        dialog.notify(this, "check");
    }
    // Checkbox specific code...
}

public class Main {
    public static void main(String[] args) {
        AuthenticationDialog dialog = new AuthenticationDialog();
        Button okBtn = new Button(dialog);
        okBtn.click();
        System.out.println("Button clicked, Mediator will handle the rest");
    }
}
