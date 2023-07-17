package web.mvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.mvc.domain.Reply;
import web.mvc.repository.ReplyRepository;

@Service //생성
@Transactional
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyRepository replyRep;

	@Override
	public void insert(Reply reply) {
		replyRep.save(reply);

	}

	@Override
	public void delete(Long id) {
		replyRep.deleteById(id);

	}

}




