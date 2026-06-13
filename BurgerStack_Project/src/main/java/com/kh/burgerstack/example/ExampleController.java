package com.kh.burgerstack.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.burgerstack.common.pagination.PagingRequest;
import com.kh.burgerstack.example.dto.ExamplePatternDetailView;
import com.kh.burgerstack.example.dto.ExamplePatternFormView;
import com.kh.burgerstack.example.dto.ExamplePatternHistoryItem;
import com.kh.burgerstack.example.dto.ExamplePatternListItem;
import com.kh.burgerstack.example.dto.ExamplePatternListView;
import com.kh.burgerstack.example.dto.ExamplePatternSearchCondition;

@Controller
@RequestMapping("example")
public class ExampleController {
    private static final List<String> MATERIAL_TYPES = List.of("AF", "RF", "FF", "PK", "KW", "ET");

    @GetMapping()
    public String index() {
        return "example/exampleIndex";
    }

    @GetMapping("patterns/list")
    public String listPattern(@RequestParam(required = false) String materialName,
            @RequestParam(required = false) String materialType,
            @RequestParam(defaultValue = "false") boolean belowSafetyStock,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            Model model) {
        ExamplePatternSearchCondition condition = new ExamplePatternSearchCondition(materialName, materialType,
                belowSafetyStock);
        List<ExamplePatternListItem> items = List.of(
                new ExamplePatternListItem(1001L, "MAT-RF-001", "냉동 소고기 패티", "RF", 42, 50,
                        new BigDecimal("378000"), LocalDate.of(2026, 6, 12)),
                new ExamplePatternListItem(1002L, "MAT-FF-014", "감자튀김", "FF", 120, 80,
                        new BigDecimal("144000"), LocalDate.of(2026, 6, 13)),
                new ExamplePatternListItem(1003L, "MAT-PK-003", "버거 포장지", "PK", 480, 300,
                        new BigDecimal("96000"), LocalDate.of(2026, 6, 14)));
        ExamplePatternListView view = new ExamplePatternListView(condition, MATERIAL_TYPES, items,
                new PagingRequest(page, size).toPageInfo(32));

        model.addAttribute("view", view);
        return "example/patterns/list";
    }

    @GetMapping("patterns/detail")
    public String detailPattern(Model model) {
        List<ExamplePatternHistoryItem> history = List.of(
                new ExamplePatternHistoryItem(LocalDateTime.of(2026, 6, 15, 9, 30), "RECEIPT", 30, 42, "정기 입고"),
                new ExamplePatternHistoryItem(LocalDateTime.of(2026, 6, 14, 22, 10), "STORE_CLOSING", -18, 12,
                        "마감 사용량 반영"),
                new ExamplePatternHistoryItem(LocalDateTime.of(2026, 6, 14, 15, 5), "ADJUSTMENT", -2, 30, "실사 오차"));
        ExamplePatternDetailView detail = new ExamplePatternDetailView(1001L, "INV-20260615-001", "강남역점",
                "MAT-RF-001", "냉동 소고기 패티", "RF", 42, 50, LocalDateTime.of(2026, 6, 15, 9, 30),
                "안전재고 미만 상태라 다음 발주 대상입니다.", history);

        model.addAttribute("detail", detail);
        return "example/patterns/detail";
    }

    @GetMapping("patterns/form")
    public String formPattern(Model model) {
        ExamplePatternFormView form = new ExamplePatternFormView(1001L, "냉동 소고기 패티", "RF", 42, 50,
                "다음 발주 전까지 임시 안전재고를 상향합니다.", MATERIAL_TYPES);

        model.addAttribute("form", form);
        return "example/patterns/form";
    }

    @PostMapping("patterns/form")
    public String submitFormPattern() {
        return "redirect:/example/patterns/form";
    }
}
