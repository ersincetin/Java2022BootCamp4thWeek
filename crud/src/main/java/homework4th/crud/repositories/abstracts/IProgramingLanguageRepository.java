package homework4th.crud.repositories.abstracts;

import homework4th.crud.entities.Language;

import java.util.List;

public interface IProgramingLanguageRepository {
    List<Language> getAll();

    Language getLanguage(int languageId);

    void addLanguage(Language course);

    void updateLanguage(Language course,int languageId);

    void deleteLanguage(int courseId);
}
