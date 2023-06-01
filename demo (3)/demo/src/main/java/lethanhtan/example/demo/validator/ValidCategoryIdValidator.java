package lethanhtan.example.demo.validator;


import jakarta.validation.ConstraintValidatorContext;
import lethanhtan.example.demo.Entity.Category;
import lethanhtan.example.demo.Repository.IUserRepository;
import lethanhtan.example.demo.validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category>{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean isValid (Category category, ConstraintValidatorContext context){
        if(userRepository == null)
            return true;
        return category != null && category.getId() != null;
    }


}
