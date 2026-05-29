package com.kh.burgerstack.example.pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.burgerstack.common.pagination.PageInfo;
import com.kh.burgerstack.common.pagination.PagingRequest;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("example")
public class ExamplePaginationController {
	@Autowired
	private ExamplePaginationService paginationService;

	@GetMapping("pagination")
	public String pagination(PagingRequest pagingRequest, HttpServletRequest request, Model model) {
		PageInfo pageInfo = paginationService.getPageInfo(pagingRequest);

		if (pageInfo.isCurrentPageOutOfRange()) {
			return "redirect:/example/pagination" + pageInfo.getLastAvailablePageQueryString(request.getQueryString());
		}

		model.addAttribute("pageInfo", pageInfo);

		return "example/examplePagination";
	}
}
