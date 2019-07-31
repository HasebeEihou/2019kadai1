
package itecafe;


public class Item {
    //商品情報
    private int no;
    private String name;
    private int price;


    public Item(int no, String name, int price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }
    //クラス　最初大文字（No）　変数&メソッド　最初小文字、繋ぎ大文字（anotherDemon）
    public int getNo() {
        return this.no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
