// TODO: @Valid と BindingResult を追加し、エラー時は register.html を返してください
@PostMapping("/register")
public String registerWord(
        ____________ @ModelAttribute Word word,
        ____________ bindingResult) {

    if (____________.____________()) {
        return "____________";
    }

    wordService.registerWord(word);
    return "redirect:/words";
}

// TODO: 同様に @Valid と BindingResult を追加し、エラー時は edit.html を返してください
@PostMapping("/words/update")
public String updateWord(
        ____________ @ModelAttribute Word word,
        ____________ bindingResult) {

    if (____________) {
        return "____________";
    }

    wordService.updateWord(word);
    return "redirect:/words";
}
