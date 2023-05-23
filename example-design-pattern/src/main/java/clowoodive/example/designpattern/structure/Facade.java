package clowoodive.example.designpattern.structure;

class ComplexLibrary1 {

    private String data;

    public ComplexLibrary1(String data) {
        this.data = data;
    }

    public String getData() {
        return data + " from lib1\n";
    }
}

class ComplexLibrary2 {

    ComplexLibrary1 complexLibrary1;

    public ComplexLibrary2(ComplexLibrary1 lib1) {
        this.complexLibrary1 = lib1;
    }

    public String calcData() {
        return complexLibrary1.getData() + "is calculated by lib2\n";
    }
}

class ComplexLibrary3 {

    public void printData(ComplexLibrary2 lib2) {
        System.out.println(lib2.calcData() + "and printed by lib3");
    }
}

class Facade {

    public void processComplexData(String input) {
        ComplexLibrary1 lib1 = new ComplexLibrary1(input);
        ComplexLibrary2 lib2 = new ComplexLibrary2(lib1);
        ComplexLibrary3 lib3 = new ComplexLibrary3();
        lib3.printData(lib2);
    }
}