case 5:
    Vocabulary q = service.getRandom();

    System.out.println("意味：" + q.getMeaning());
    System.out.print("単語は？:");

    String ans = sc.nextLine();

    if (ans.equalsIgnoreCase(q.getWord())) {
        System.out.println("正解！");
    } else {
        System.out.println("不正解 正解：" + q.getWord());
    }
    break;
