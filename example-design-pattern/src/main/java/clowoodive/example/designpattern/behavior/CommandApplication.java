package clowoodive.example.designpattern.behavior;

interface Command {
    void execute();
}

class CopyButtonInvoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

class PasteButtonInvoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

class EditorReceiver {

    private String text1 = "text1";

    private String text2 = "text2";

    private String clipboard = "";

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }
}

class CopyCommand implements Command {

    EditorReceiver editor;

    String param;

    public CopyCommand(EditorReceiver editor, String param) {
        this.editor = editor;
        this.param = param;
    }

    @Override
    public void execute() {
        this.editor.setClipboard(this.editor.getText1() + param);
        System.out.println("copyCommand executed, editor.text1 copy to clipboard");
    }
}

class PasteCommand implements Command {

    EditorReceiver editor;

    String param;

    public PasteCommand(EditorReceiver editor, String param) {
        this.editor = editor;
        this.param = param;
    }

    @Override
    public void execute() {
        this.editor.setText2(this.editor.getClipboard() + param);
        System.out.println("pasteCommand executed, clipboard copy to editor.text2");
    }
}


// 참고글 예제처럼 복잡한 기능을 고려한 예제
//  - 인터페이스 대신 추상 클래스를 상속한 커맨드 사용
//  - 버튼의 리스너 등록방식을 흉내내기 위한 콜백 사용
//  - 히스토리를 사용하기 위해 버튼이 커맨드를 직접 호출하지 않고 application의 executeCommand를 통해서 호출

//interface ExecuteCallback {
//    void callExecuteCommand();
//}
//
//// invoker
//class CopyButton {
//
//    ExecuteCallback callback;
//
//    public CopyButton(ExecuteCallback callback) {
//        this.callback = callback;
//    }
//
//    public void action() {
//        this.callback.callExecuteCommand();
//    }
//}
//
//class PasteButton {
//
//    ExecuteCallback callback;
//
//    public PasteButton(ExecuteCallback callback) {
//        this.callback = callback;
//    }
//
//    public void action() {
//        this.callback.callExecuteCommand();
//    }
//}
//
//class EditorReceiver {
//
//    private String text1 = "editor's text1";
//
//    private String text2 = "editor's text2";
//
//    private String clipboard = "";
//
//    public String getText1() {
//        return text1;
//    }
//
//    public void setText1(String text1) {
//        this.text1 = text1;
//    }
//
//    public String getText2() {
//        return text2;
//    }
//
//    public void setText2(String text2) {
//        this.text2 = text2;
//    }
//
//    public String getClipboard() {
//        return clipboard;
//    }
//
//    public void setClipboard(String clipboard) {
//        this.clipboard = clipboard;
//    }
//}
//
//public class CommandApplication {
//
//    public CopyButton copyButton;
//
//    public PasteButton pasteButton;
//
//    public EditorReceiver editorReceiver;
//
//    public void init() {
//        editorReceiver = new EditorReceiver();
//
//        this.copyButton = new CopyButton(new ExecuteCallback() {
//            @Override
//            public void callExecuteCommand() {
//                executeCommand(new CopyCommand(editorReceiver));
//            }
//        });
//
//        this.pasteButton = new PasteButton(new ExecuteCallback() {
//            @Override
//            public void callExecuteCommand() {
//                executeCommand(new PasteCommand(editorReceiver));
//            }
//        });
//    }
//
//    public void executeCommand(Command command) {
//        command.execute();
//    }
//}
//
//abstract class Command {
//
//    EditorReceiver editorReceiver;
//
//    public Command(EditorReceiver editorReceiver) {
//        this.editorReceiver = editorReceiver;
//    }
//
//    // 공통 기능
//    public void undo() {
//    }
//
//    // command 제공 인터페이스
//    public abstract void execute();
//}
//
//class CopyCommand extends Command {
//
//    public CopyCommand(EditorReceiver editorReceiver) {
//        super(editorReceiver);
//    }
//
//    @Override
//    public void execute() {
//        this.editorReceiver.setClipboard(this.editorReceiver.getText1());
//        System.out.println("copyCommand executed, editor.text1 saved in clipboard");
//    }
//}
//
//class PasteCommand extends Command {
//
//    public PasteCommand(EditorReceiver editorReceiver) {
//        super(editorReceiver);
//    }
//
//    @Override
//    public void execute() {
//        this.editorReceiver.setText2(this.editorReceiver.getClipboard());
//        System.out.println("pasteCommand executed, clipboard saved in editor.text2");
//    }
//}