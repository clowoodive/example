package clowoodive.example.designpattern.creation;

abstract class ProductMaker {

    // 주요 관심사 로직 따로 존재
    public Product makeProduct(int modelNumber, int price) {
        Product product = createProduct();
        product.setModelNumber(modelNumber);
        product.setPrice(price);
        return product;
    }

    // 내부에서 필요한 객체 생성 로직 분리
    abstract Product createProduct();
}

class FullPackageProductMaker extends ProductMaker {

    @Override
    protected Product createProduct() {
        return new FullPkgProduct();
    }
}

class BulkPackageProductMaker extends ProductMaker {

    @Override
    protected Product createProduct() {
        return new BulkPkgProduct();
    }
}

interface Product {

    void setModelNumber(int modelNumber);

    void setPrice(int price);

    void delivery();
}

class FullPkgProduct implements Product {
    private int modelNumber;

    private int price;

    @Override
    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void delivery() {
        System.out.println("FullPkgProduct delivery");
    }
}

class BulkPkgProduct implements Product {
    private int modelNumber;

    private int price;

    @Override
    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void delivery() {
        System.out.println("BulkPkgProduct delivery");
    }
}