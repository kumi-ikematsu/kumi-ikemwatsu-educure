public class ArrayAccessor {

    private int[] array;

    // コンストラクタ
    public ArrayAccessor(int[] array) {
        this.array = array;
    }

    // 指定位置の要素を取得
    public int getElement(int index) throws Exception {

        if (index < 0 || index >= array.length) {
            throw new Exception("エラー：指定された位置は範囲外です");
        }

        return array[index];
    }
}