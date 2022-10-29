package homework4th.crud.repositories.concretes;

import homework4th.crud.entities.Language;
import homework4th.crud.repositories.abstracts.IProgramingLanguageRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgramingLanguageRepository implements IProgramingLanguageRepository {

    private List<Language> languages = new ArrayList<Language>();

    @Override
    public List<Language> getAll() {
        return this.languages;
    }

    @Override
    public Language getLanguage(int languageId) {
        return languages.stream().filter(language -> language.getId() == languageId).findFirst().get();
    }

    @Override
    public void addLanguage(Language language) {
        this.languages.add(language);
    }

    @Override
    public void updateLanguage(Language language, int languageId) {
        Language languageRecord = getLanguage(languageId);
        languageRecord.setName(language.getName());
    }

    @Override
    public void deleteLanguage(int languageId) {
        this.languages.remove(getLanguage(languageId));
    }
}
