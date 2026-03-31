public class VocabularyService {

    private VocabularyDAO dao;

    public VocabularyService(Connection con) {
        this.dao = new VocabularyDAO(con);
    }

    // 登録
    public boolean add(String word, String meaning) throws Exception {
        return dao.insert(word, meaning) > 0;
    }

    // 一覧
    public List<Vocabulary> getAll() throws Exception {
        return dao.findAll();
    }

    // 更新
    public boolean update(String word, String meaning) throws Exception {
        return dao.update(word, meaning) > 0;
    }

    // 削除
    public boolean delete(String word) throws Exception {
        return dao.delete(word) > 0;
    }

    // クイズ機能
    public Vocabulary getRandom() throws Exception {
        List<Vocabulary> list = dao.findAll();
        return list.get(new java.util.Random().nextInt(list.size()));
    }

    // CSVインポート
    public void importCSV(String file) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            dao.insert(data[0], data[1]);
        }
        br.close();
    }

    // CSVエクスポート
    public void exportCSV(String file) throws Exception {
        java.util.List<Vocabulary> list = dao.findAll();
        java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(file));

        for (Vocabulary v : list) {
            bw.write(v.getWord() + "," + v.getMeaning());
            bw.newLine();
        }
        bw.close();
    }
}
