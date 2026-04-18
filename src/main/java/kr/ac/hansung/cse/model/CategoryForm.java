package kr.ac.hansung.cse.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor // Spring MVC 폼 바인딩 필수: 기본 생성자가 있어야 합니다.
public class CategoryForm {

    private Long id;


    @NotBlank(message = "카테고리 이름을 입력하세요")
    @Size(max = 50, message = "50자 이내로 입력하세요")
    private String name;




    // ─────────────────────────────────────────────────────────────────
    // 변환 메서드 (DTO ↔ Entity)
    // ─────────────────────────────────────────────────────────────────


    public Category toEntity() {
        return new Category(this.name);
    }


    public static CategoryForm from(Category category) {
        CategoryForm form = new CategoryForm();
        form.id = category.getId();
        form.name = category.getName();
        return form;
    }
}

