package prog05.aplicacion;

public class CuentaBancaria {
	
	private double saldo;
	private CCC ccc;
	private Nome nome;
        private static int maxLonxNome=30;
	
	public CuentaBancaria() {}
        
	public CuentaBancaria (Nome nome, CCC ccc) throws Exception{
            if (comprobaNome(nome)){
                this.ccc=ccc;
		this.nome=nome;
		this.saldo=0;
            } else{
                throw new Exception("O nome introducido excede a lonxitude maxima");
            }
	}
        
	private boolean comprobaImporte(String importe) {
		try {
			Double imp=Double.parseDouble(importe);
                        if( imp <= 0.0){
                            return true;
                        } else{
                            return false;
                        }
		} catch (NumberFormatException e) {
			return false;
		}
	}
        
	public void ingresoEfectivo (String ingreso) throws Exception {
		if (comprobaImporte(ingreso)) {
			this.saldo=this.saldo+Double.parseDouble(ingreso);
		}else {
			throw new Exception("Erro no importe introducido");
		}
	}
	
	public void retiradaEfectivo (String retirada) throws Exception  {
		if(!comprobaImporte(retirada)) {
			throw new Exception("Erro no formato da cantidade introducido");
		}
		if (Double.parseDouble(retirada)>this.saldo) {
			throw new Exception("Non hai fondos suficientes!, saldo actual: "+this.saldo);
		}else {
			this.saldo=this.saldo-Double.parseDouble(retirada);
		}
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public CCC getCcc() {
		return this.ccc;
	}
	public void setCcc(CCC ccc) {
		this.ccc = ccc;
	}
	public Nome getNome() {
		return this.nome;
	}
}