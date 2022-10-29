package homework4th.crud.sevices.abstracts;

import homework4th.crud.entities.Language;

import java.util.List;

public interface ILanguageManager {
    List<Language> getAll();

    void add(Language language) throws Exception;

    void update(Language language, int languageId) throws Exception;

    void delete(int languageId) throws Exception;

    Language getLanguage(int languageId);
}
