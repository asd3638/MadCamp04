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
 * @RequiredArgsConstructor //�씠�윭硫� final留� �옒 紐낆떆�븯硫� �맂�떎.
 * 
 * @RequestMapping("/board/*")
 * 
 * @Log4j public class BoardController {
 * 
 * //鍮꾩��땲�뒪�솕 �뻽�쑝�땲源� �씠�젣 �뜑 �씠�긽 mapper瑜� 蹂대㈃ �븞�맂�떎. private final BoardService service;
 * 
 * //寃뚯떆�뙋�쓽 �젙蹂대뒗 db濡쒕��꽣 遺덈윭���빞 �븯湲� �븣臾몄뿉 臾댁“嫄� Model�쓣 �뜥�빞�븳�떎. //model�쓣 �넻�빐�꽌 �뜲�씠�꽣瑜� �꽔�뒗 寃껋�
 * addattribute瑜� �궗�슜�븳�떎.
 * 
 * @GetMapping("list") public void list(Criteria cri, Model model) {
 * 
 * log.info("..........listwithpaging..........."); log.info(cri);
 * log.info("..........listwithpaging...........");
 * 
 * //service�쓽 getlist硫붿냼�뱶瑜� �씠�슜�빐�꽌 �뜲�씠�꽣瑜� 諛쏆븘���꽌 medel�뿉 ���옣�빐�몢�뒗 寃껋씠�떎.
 * model.addAttribute("list", service.getList(cri));
 * model.addAttribute("pageMaker", new PageDTO(cri,
 * service.getTotalCount(cri))); } //�벑濡�
 * 
 * @GetMapping("register") public void registerGet() { }
 * 
 * //�럹�씠吏��뿉�꽌 �븸�뀡 踰꾪듉 �씠踰ㅽ듃媛� 諛쒖깮�븯硫� postmapping �떎�뻾
 * 
 * @PostMapping("register") public String register(BoardVO board,
 * RedirectAttributes rttr) {
 * 
 * log.info("board: " + board); Long bno = service.register(board);
 * log.info("bno: " + bno);
 * 
 * rttr.addFlashAttribute("result", bno);
 * 
 * return "redirect:/board/list"; } //�닔�젙 (modify瑜� �늻瑜대㈃ get �쑝濡�)
 * 
 * @PostMapping("modify") public String modify(BoardVO board, Criteria cri,
 * RedirectAttributes rttr) {
 * 
 * log.info("board: " + board); int count = service.modify(board); //�닔�젙�씠 �릱�뒗吏� �븞
 * �릱�뒗吏� return媛믪쓣 媛�吏�怨� �솗�씤�쓣 �빆�긽 �빐�빞�븳�떎. if (count == 1) {
 * rttr.addFlashAttribute("result", "modify"); }
 * 
 * //post 諛⑹떇�� view�뿉�꽌 �뜲�씠�꽣瑜� �떖怨� �떎�땶�떎怨� redirection�뿉 �쟾�떖�릺吏� �븡�쑝�땲源� 遺꾧린 硫붿냼�뱶�뿉�꽌 addattribute濡�
 * �뜲�씠�꽣瑜� 留덉� �떖�븘以섏빞 �븳�떎. rttr.addAttribute("pageNum", cri.getPageNum());
 * rttr.addAttribute("amount", cri.getAmount());
 * 
 * return "redirect:/board/list"; }
 * 
 * //�궘�젣
 * 
 * @PostMapping("remove") public String remove(Long bno, Criteria cri,
 * RedirectAttributes rttr) { int count = service.remove(bno);
 * 
 * if (count == 1) { rttr.addFlashAttribute("result", "remove"); }
 * 
 * rttr.addAttribute("pageNum", cri.getPageNum()); rttr.addAttribute("amount",
 * cri.getAmount()); //寃��깋 ���엯�씠 異붽��릺�뼱�빞�븳�떎. //rttr.addAttribute("pageNum",
 * cri.getType()); //rttr.addAttribute("amount", cri.getKeyword());
 * 
 * return "redirect:/board/list"; }
 * 
 * //議고쉶 //mapping ���긽�뿉 2媛쒖쓽 �럹�씠吏�濡� 遺꾧린�떆耳곕뒗�뜲 �썝�옒 return媛믪씠 void�씠湲� �븣臾몄뿉 get�씠硫� get�쑝濡� modify�뒗
 * modify濡� �꽆�뼱媛꾨떎. //@ModelAttribute瑜� �벐硫� 紐낆떆�쟻�쑝濡� cri�씪�뒗 �씠由꾩쑝濡� Criteria瑜� ���옣�븷 �닔 �엳�떎.
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
