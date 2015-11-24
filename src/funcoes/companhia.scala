package funcoes

object companhia extends App {
  
  // funcao que retorna assentos livres de uma aeronave
  // passando uma aeronave e uma funcao por parametro
  
  def assentosLivres(aeronave:List[List[Int]])(f:(List[Int]) => (Int) => Int):Int = {
    var resultado = 0
    aeronave.foreach( x => {
      resultado += f(x)(0)
    })
    resultado
  }
  
  //  funcao para retornar numero de assentos livres/ocupados
  //  passando uma fila de assentos por parâmetro e uma flag
  //  com o valor desejado
  
  var assentosPorFila = (lista:List[Int]) => (flag:Int) => {
    var resultado = 0
    lista.foreach( x => {
        if(x == flag)
          resultado += 1
    })
    resultado
  }
  
  var aeronave = List(
              List(0, 0, 1),
              List(1, 0, 1)
           )
  
  // 1) A - Assentos livres de uma aeronave
  println("Qtd. de assentos livres da Aeronave: " + assentosLivres(aeronave)(assentosPorFila))
  // 1) B - Assentos ocupados, dada uma fila  
  println("Qtd. de assentos ocupados da fila: " + assentosPorFila(aeronave(0))(1))
  
}