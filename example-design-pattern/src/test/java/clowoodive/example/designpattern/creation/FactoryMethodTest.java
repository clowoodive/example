package clowoodive.example.designpattern.creation;

import org.junit.jupiter.api.Test;

class FactoryMethodTest {

    @Test
    void factoryMethod() {
        ProductMaker fullPkgProductMaker = new FullPackageProductMaker();
        ProductMaker bulkPkgProductMaker = new BulkPackageProductMaker();
        Product fullProduct = fullPkgProductMaker.makeProduct(1234, 5000);
        Product bulkProduct = bulkPkgProductMaker.makeProduct(5678, 12000);

        fullProduct.delivery();
        bulkProduct.delivery();
    }
}