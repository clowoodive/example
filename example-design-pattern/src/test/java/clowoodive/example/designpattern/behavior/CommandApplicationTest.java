package clowoodive.example.designpattern.behavior;

import org.junit.jupiter.api.Test;

class CommandApplicationTest {

    @Test
    void command() {
        EditorReceiver editor = new EditorReceiver();
        Command copyCommand = new CopyCommand(editor, "(copied to clipboard)");
        Command pastCommand = new PasteCommand(editor, "(and copied to text2)");
        CopyButtonInvoker copyButton = new CopyButtonInvoker();
        PasteButtonInvoker pasteButton = new PasteButtonInvoker();
        copyButton.setCommand(copyCommand);
        pasteButton.setCommand(pastCommand);

        System.out.println("----- before -----");
        System.out.println("editor.text1 : " + editor.getText1());
        System.out.println("editor.text2 : " + editor.getText2());
        System.out.println("editor.clipboard : " + editor.getClipboard());

        System.out.println("----- action -----");
        copyButton.executeCommand();
        pasteButton.executeCommand();

        System.out.println("----- after -----");
        System.out.println("editor.text1 : " + editor.getText1());
        System.out.println("editor.text2 : " + editor.getText2());
        System.out.println("editor.clipboard : " + editor.getClipboard());
    }

//    @Test
//    void command() {
//        CommandApplication application = new CommandApplication();
//        application.init();
//
//        System.out.println("editor.text1 : " + application.editorReceiver.getText1());
//        System.out.println("editor.text2 : " + application.editorReceiver.getText2());
//        System.out.println("editor.clipboard : " + application.editorReceiver.getClipboard());
//
//        application.copyButton.action();
//        application.pasteButton.action();
//
//        System.out.println("editor.text1 : " + application.editorReceiver.getText1());
//        System.out.println("editor.text2 : " + application.editorReceiver.getText2());
//        System.out.println("editor.clipboard : " + application.editorReceiver.getClipboard());
//    }
}