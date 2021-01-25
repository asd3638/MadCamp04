/*
 * package org.zerock.controller;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.servlet.mvc.support.RedirectAttributes; import
 * org.zerock.domain.BoardVO; import org.zerock.domain.Criteria; import
 * org.zerock.domain.PageDTO; import org.zerock.service.BoardService;
 * 
 * import lombok.RequiredArgsConstructor; import lombok.extern.log4j.Log4j;
 * 
 * @Controller
 * 
 * @RequiredArgsConstructor //이러면 final만 잘 명시하면 된다.
 * 
 * @RequestMapping("/board/*")
 * 
 * @Log4j public class BoardController {
 * 
 * //비지니스화 했으니까 이제 더 이상 mapper를 보면 안된다. private final BoardService service;
 * 
 * //게시판의 정보는 db로부터 불러와야 하기 때문에 무조건 Model을 써야한다. //model을 통해서 데이터를 넣는 것은
 * addattribute를 사용한다.
 * 
 * @GetMapping("list") public void list(Criteria cri, Model model) {
 * 
 * log.info("..........listwithpaging..........."); log.info(cri);
 * log.info("..........listwithpaging...........");
 * 
 * //service의 getlist메소드를 이용해서 데이터를 받아와서 medel에 저장해두는 것이다.
 * model.addAttribute("list", service.getList(cri));
 * model.addAttribute("pageMaker", new PageDTO(cri,
 * service.getTotalCount(cri))); } //등록
 * 
 * @GetMapping("register") public void registerGet() { }
 * 
 * //페이지에서 액션 버튼 이벤트가 발생하면 postmapping 실행
 * 
 * @PostMapping("register") public String register(BoardVO board,
 * RedirectAttributes rttr) {
 * 
 * log.info("board: " + board); Long bno = service.register(board);
 * log.info("bno: " + bno);
 * 
 * rttr.addFlashAttribute("result", bno);
 * 
 * return "redirect:/board/list"; } //수정 (modify를 누르면 get 으로)
 * 
 * @PostMapping("modify") public String modify(BoardVO board, Criteria cri,
 * RedirectAttributes rttr) {
 * 
 * log.info("board: " + board); int count = service.modify(board); //수정이 됐는지 안
 * 됐는지 return값을 가지고 확인을 항상 해야한다. if (count == 1) {
 * rttr.addFlashAttribute("result", "modify"); }
 * 
 * //post 방식은 view에서 데이터를 달고 다닌다고 redirection에 전달되진 않으니까 분기 메소드에서 addattribute로
 * 데이터를 마저 달아줘야 한다. rttr.addAttribute("pageNum", cri.getPageNum());
 * rttr.addAttribute("amount", cri.getAmount());
 * 
 * return "redirect:/board/list"; }
 * 
 * //삭제
 * 
 * @PostMapping("remove") public String remove(Long bno, Criteria cri,
 * RedirectAttributes rttr) { int count = service.remove(bno);
 * 
 * if (count == 1) { rttr.addFlashAttribute("result", "remove"); }
 * 
 * rttr.addAttribute("pageNum", cri.getPageNum()); rttr.addAttribute("amount",
 * cri.getAmount()); //검색 타입이 추가되어야한다. //rttr.addAttribute("pageNum",
 * cri.getType()); //rttr.addAttribute("amount", cri.getKeyword());
 * 
 * return "redirect:/board/list"; }
 * 
 * //조회 //mapping 대상에 2개의 페이지로 분기시켰는데 원래 return값이 void이기 때문에 get이면 get으로 modify는
 * modify로 넘어간다. //@ModelAttribute를 쓰면 명시적으로 cri라는 이름으로 Criteria를 저장할 수 있다.
 * 
 * @GetMapping({"get", "modify"}) public void get(Long
 * bno, @ModelAttribute("cri") Criteria cri, Model model) {
 * 
 * model.addAttribute("board", service.get(bno)); } }
 */

package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;

	@GetMapping("/register")
	public void register() {

	}

	// @GetMapping("/list")
	// public void list(Model model) {
	//
	// log.info("list");
	// model.addAttribute("list", service.getList());
	//
	// }

	// @GetMapping("/list")
	// public void list(Criteria cri, Model model) {
	//
	// log.info("list: " + cri);
	// model.addAttribute("list", service.getList(cri));
	//
	// }

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {

		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		// model.addAttribute("pageMaker", new PageDTO(cri, 123));

		int total = service.getTotal(cri);

		log.info("total: " + total);

		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {

		log.info("register: " + board);

		service.register(board);

		rttr.addFlashAttribute("result", board.getBno());

		return "redirect:/board/list";
	}

	// @GetMapping({ "/get", "/modify" })
	// public void get(@RequestParam("bno") Long bno, Model model) {
	//
	// log.info("/get or modify ");
	// model.addAttribute("board", service.get(bno));
	// }

	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}

	// @PostMapping("/modify")
	// public String modify(BoardVO board, RedirectAttributes rttr) {
	// log.info("modify:" + board);
	//
	// if (service.modify(board)) {
	// rttr.addFlashAttribute("result", "success");
	// }
	// return "redirect:/board/list";
	// }

	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}

		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/board/list";
	}

	// @PostMapping("/remove")
	// public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr)
	// {
	//
	// log.info("remove..." + bno);
	// if (service.remove(bno)) {
	// rttr.addFlashAttribute("result", "success");
	// }
	// return "redirect:/board/list";
	// }

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {

		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/board/list";
	}

}
