package homework4th.crud.sevices.concretes;

import homework4th.crud.entities.Language;
import homework4th.crud.repositories.abstracts.IProgramingLanguageRepository;
import homework4th.crud.sevices.abstracts.ILanguageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements ILanguageManager {
    private final IProgramingLanguageRepository languageRepository;

    @Autowired
    public LanguageManager(IProgramingLanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return this.languageRepository.getAll();
    }

    @Override
    public void add(Language language) throws Exception {
        if (isIdExist(language.getId())) throw new Exception("Id Not Found");
        if (isNameExist(language)) throw new Exception("Name Cannot Be Repeated");
        this.languageRepository.addLanguage(language);
    }

    @Override
    public void update(Language language, int languageId) throws Exception {
        if (isIdExist(languageId)) throw new Exception("Id Not Found");
        if (isNameExist(language)) throw new Exception("Name Cannot Be Repeated");
        this.languageRepository.updateLanguage(language, languageId);
    }

    @Override
    public void delete(int languageId) throws Exception {
        if (isIdExist(languageId)) throw new Exception("Id Not Found");
        this.languageRepository.deleteLanguage(languageId);
    }

    @Override
    public Language getLanguage(int languageId) {
        return this.languageRepository.getLanguage(languageId);
    }

    public boolean isIdExist(int languageId) {
        for (Language language : getAll()) {
            if (language.getId() == languageId) {
                return true;
            }
        }
        return false;
    }

    public boolean isNameExist(Language language) {
        for (Language languageRecord : getAll()) {
            if (languageRecord.getName().equals(language.getName())) {
                return true;
            }
        }
        return false;
    }
}
