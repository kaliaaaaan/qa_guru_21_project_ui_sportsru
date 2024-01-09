package page.component;

import org.junit.jupiter.params.provider.Arguments;
import datatest.Menu;

import java.util.List;
import java.util.stream.Stream;

public class MenuPage {

    public static Stream<Arguments> sportRuTestMenu() {
        return Stream.of(
                Arguments.of(Menu.MAIN, List.of("Новости", "Посты", "Матчи", "Футбол", "Хоккей", "Баскет", "Фигурка", "Теннис", "Бокс", "Авто")),
                Arguments.of(Menu.FOOTBALL, List.of("Новости", "Посты", "Матчи", "РПЛ", "Фэнтези", "АПЛ", "ЛЧ", "Евро-2024", "ЛЕ", "ЛК", "Серия А")),
                Arguments.of(Menu.HOCKEY, List.of("Новости", "Посты", "Матчи", "НХЛ", "КХЛ", "Фэнтези", "Команды", "Турниры", "Хоккеисты"))
        );
    }
}
