package funcoes

object companhia extends App {

  // 1) A
  // funcao que retorna assentos livres de uma aeronave
  // passando uma aeronave e uma funcao por parametro
  def assentosLivresAeronave(aeronave:List[List[Int]]) (f:(List[Int]) => (Int) => Int):Int = {
    var resultado = 0
    aeronave.foreach( x => {
      resultado += f(x)(0)
    })
    resultado
  }
  
  // 1) B
  // funcao para retornar numero de assentos livres/ocupados
  // passando uma fila de assentos por parametro e uma flag
  // com o valor desejado
  var assentosPorFila = (lista:List[Int]) => (flag:Int) => lista.filter(_ == flag).size
  
  // 1) C
  def assentosConinuosLivres(fila: List[Int]) = {
    fila.map(x => {
		if (x == 0)
			x
	    })
  }
  
  var aeronave = List(
              List(0, 0, 1, 1, 0, 1),
              List(1, 0, 0, 0, 1, 0)
           )
  
  println("Qtd. de assentos livres da Aeronave: " + assentosLivresAeronave(aeronave)(assentosPorFila))  
  println("Qtd. de assentos ocupados da fila: " + assentosPorFila(aeronave(0))(1))
  println("Assentos continuos livres de uma fila: " + assentosConinuosLivres(aeronave(0)))
  
}