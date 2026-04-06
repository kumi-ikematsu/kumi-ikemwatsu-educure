import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserProfileController {

    // ダミーユーザーデータ
    private static Map<Integer, UserProfileForm> users = new HashMap<>();
    static {
        users.put(1, new UserProfileForm("田中太郎", 30, "よろしくお願いします！"));
    }

    // プロフィール表示
    @GetMapping("/profile/{id}")
    public String profileView(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("profile", users.get(id));
        return "profile-view";
    }

    // 編集画面表示
    @GetMapping("/profile/{id}/edit")
    public String profileEdit(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("form", users.get(id));
        return "profile-edit";
    }

    // 確認画面表示
    @PostMapping("/profile/{id}/confirm")
    public String profileConfirm(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String bio,
            Model model) {
        UserProfileForm form = new UserProfileForm(name, age, bio);
        model.addAttribute("id", id);
        model.addAttribute("form", form);
        return "profile-confirm";
    }

    // 確定処理
    @PostMapping("/profile/{id}/update")
    public String profileUpdate(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String bio,
            Model model) {
        UserProfileForm updated = new UserProfileForm(name, age, bio);
        users.put(id, updated);
        model.addAttribute("id", id);
        model.addAttribute("profile", updated);
        model.addAttribute("message", "プロフィールが更新されました！");
        return "profile-view";
    }
}
