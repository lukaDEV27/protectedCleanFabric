package br.com.protectedCleanFabric.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido", schema = "prolimper")
public class PedidoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;
	
	@Column(name = "num_pedido")
	private String numPedido;
	
	@Column(name = "num_pedido_vendedor")
	private String numPedidoVendedor;
	
	@Column(name = "vendedor")
	private String vendedor;
	
	@Column(name = "loja_vendedor")
	private String lojaVendedor;
	
	@Column(name = "intermediador")
	private String intermediador;
	
	@Column(name = "data_pedido")
	private Date dataPedido;
	
	@Column(name = "data_agendamento")
	private Date dataAgendamento;
	
	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "tipo_servico")
	private String tipoServicos;
	
	@ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(String numPedido) {
		this.numPedido = numPedido;
	}

	public String getNumPedidoVendedor() {
		return numPedidoVendedor;
	}

	public void setNumPedidoVendedor(String numPedidoVendedor) {
		this.numPedidoVendedor = numPedidoVendedor;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getLojaVendedor() {
		return lojaVendedor;
	}

	public void setLojaVendedor(String lojaVendedor) {
		this.lojaVendedor = lojaVendedor;
	}

	public String getIntermediador() {
		return intermediador;
	}

	public void setIntermediador(String intermediador) {
		this.intermediador = intermediador;
	}

	

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTipoServicos() {
		return tipoServicos;
	}

	public void setTipoServicos(String tipoServicos) {
		this.tipoServicos = tipoServicos;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

//	
}
