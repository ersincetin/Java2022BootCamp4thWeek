package homework4th.crud.controllers;

import homework4th.crud.entities.Language;
import homework4th.crud.sevices.abstracts.ILanguageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/languages")
public class LanguageController {
    private ILanguageManager languageManager;

    @Autowired
    public LanguageController(ILanguageManager languageManager) {
        this.languageManager = languageManager;
    }

    @GetMapping()
    public List<Language> getAll() {
        return this.languageManager.getAll();
    }

    @GetMapping(value = "/{languageId}")
    public Language getLanguage(@PathVariable("languageId") int languageId) {
        return this.languageManager.getLanguage(languageId);
    }

    @PostMapping(value = "/add")
    public void addLanguage(@RequestBody Language language) throws Exception {
        this.languageManager.add(language);
    }

    @PutMapping(value = "/update/{languageId}")
    public void updateLanguage(@RequestBody Language language, @PathVariable("languageId") int languageId) throws Exception {
        this.languageManager.update(language, languageId);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteLanguage(@PathVariable("languageId") int languageId) throws Exception {
        this.languageManager.delete(languageId);
    }
}
