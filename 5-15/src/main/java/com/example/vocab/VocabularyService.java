public boolean add(String word, String meaning) throws Exception {
    return dao.insert(word, meaning) > 0;
}
