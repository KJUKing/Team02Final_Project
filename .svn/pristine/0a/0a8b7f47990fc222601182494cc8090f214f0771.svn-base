package kr.or.ddit.commons.paging.renderer;

import kr.or.ddit.commons.paging.PaginationInfo;

public class renderPagination implements PaginationRenderer {

	// 키워드 검색 필요시 카톡 부탁 드립니다.
	@Override
	public String renderPagination(PaginationInfo paging, String fnName) {
		int startPage = paging.getStartPage();
		int endPage = paging.getEndPage();
		int totalPage = paging.getTotalPage();
		int blockSize = paging.getBlockSize();
		int currentPage = paging.getCurrentPage();

		endPage = endPage > totalPage ? totalPage : endPage;

		StringBuffer html = new StringBuffer();
		html.append("<ul class='pagination'>");

		String pattern =
				"<li class='page-item'>"
						+ "<a class='page-link' href='?page=%d'>%s</a>"
						+ "</li>";
		String activePattern =
				"<li class='page-item active'>"
						+ "<a class='page-link' href='?page=%d'>%s</a>"
						+ "</li>";
		String prevPattern =
				"<li class='page-item prev'>"
						+ "<a class='page-link' href='?page=%d'>"
						+ "<li class='tf-icon bx bx-chevron-left'></li>"
						+ "</a>"
						+ "</li>";
		String nextPattern =
				"<li class='page-item next'>"
						+ "<a class='page-link' href='?page=%d'>"
						+ "<li class='tf-icon bx bx-chevron-right'></li>"
						+ "</a>"
						+ "</li>";

		if (startPage > blockSize) {
			html.append(String.format(prevPattern, (startPage - blockSize)));
		}

		for (int page = startPage; page <= endPage; page++) {
			if (page == currentPage) {
				html.append(String.format(activePattern, page, page)); // 두 개의 값 전달
			} else {
				html.append(String.format(pattern, page, page)); // 두 개의 값 전달
			}
		}

		if (endPage < totalPage) {
			html.append(String.format(nextPattern, (endPage + 1)));
		}

		html.append("</ul>");
		return html.toString();
	}
}