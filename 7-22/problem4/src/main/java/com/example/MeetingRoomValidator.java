package com.example;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class MeetingRoomValidator implements Validator {

    private static final LocalTime OPEN_TIME = LocalTime.of(9, 0);
    private static final LocalTime CLOSE_TIME = LocalTime.of(18, 0);

    @Override
    public boolean supports(Class<?> clazz) {
        return MeetingRoomForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeetingRoomForm form = (MeetingRoomForm) target;

        LocalDateTime start = form.getStartDateTime();
        LocalDateTime end = form.getEndDateTime();
        Integer people = form.getPeopleCount();
        String room = form.getRoomName();

        if (start == null || end == null || people == null || room == null) {
            return;
        }

        // 平日チェック
        DayOfWeek day = start.getDayOfWeek();
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            errors.rejectValue("startDateTime", "", "平日9:00〜18:00の間で予約してください");
        }

        // 営業時間チェック
        LocalTime startTime = start.toLocalTime();
        LocalTime endTime = end.toLocalTime();
        if (startTime.isBefore(OPEN_TIME) || endTime.isAfter(CLOSE_TIME)) {
            errors.rejectValue("startDateTime", "", "平日9:00〜18:00の間で予約してください");
        }

        // 最大3時間チェック
        if (!end.isAfter(start)) {
            errors.rejectValue("endDateTime", "", "終了日時は開始日時より後にしてください");
        } else {
            long minutes = java.time.Duration.between(start, end).toMinutes();
            if (minutes > 180) {
                errors.rejectValue("endDateTime", "", "最大利用時間は3時間までです");
            }
        }

        // 人数と会議室の整合性チェック
        if (people >= 10 && "小会議室".equals(room)) {
            errors.rejectValue("roomName", "", "10人以上の場合は大会議室を選択してください");
        }
        if (people <= 9 && "大会議室".equals(room)) {
            errors.rejectValue("roomName", "", "9人以下の場合は小会議室を選択してください");
        }
    }
}
