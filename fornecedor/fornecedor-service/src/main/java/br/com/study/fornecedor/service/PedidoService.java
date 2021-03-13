package br.com.study.fornecedor.service;

import br.com.study.fornecedor.dto.ItemDoPedidoDTO;
import br.com.study.fornecedor.model.Pedido;
import br.com.study.fornecedor.model.PedidoItem;
import br.com.study.fornecedor.repository.PedidoItemRepository;
import br.com.study.fornecedor.repository.PedidoRepository;
import br.com.study.fornecedor.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {
		
		if(itens == null) {
			return null;
		}
		final List<PedidoItem> pedidoItens = new ArrayList<>();
		for(ItemDoPedidoDTO item : itens) {
			pedidoItens.add(modelMapper.map(item, PedidoItem.class));
		}
		Iterable<PedidoItem> pedidoItems = this.pedidoItemRepository.saveAll(pedidoItens);
		pedidoItens.clear();
		pedidoItems.forEach(pedidoItens::add);
		Pedido pedido = new Pedido(pedidoItens);
		pedido.setTempoDePreparo(itens.size());
		return pedidoRepository.save(pedido);
	}
	
	public Pedido getPedidoPorId(Long id) {
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	}

}
