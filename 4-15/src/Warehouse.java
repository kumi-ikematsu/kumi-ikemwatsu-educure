public class Warehouse<T> {

    private T item;

    // 商品を保存
    public void store(T item) {
        this.item = item;
        System.out.println("商品追加: " + item);
    }

    // 商品を取り出す
    public T retrieve() {
        T temp = item;
        item = null;
        System.out.println("取り出し: " + temp);
        return temp;
    }

    // 空かどうかチェック
    public boolean isEmpty() {
        return item == null;
    }
}