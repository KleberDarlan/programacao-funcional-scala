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
  // funcao para retornar conjundo com assentos contínuos livres
  def assentosConinuosLivres(fila: List[Int]) = {
    var assentos = fila.zipWithIndex.filter(_._1 == 0).map(_._2)
    var assentosLivres:List[Int] = Nil
      
    assentos.sliding(2).foreach(x => {
      if(x(1) == x(0) + 1)
        x.foreach { x => assentosLivres = x::assentosLivres }
    })
    
    assentosLivres.distinct.sorted
  }
  
  var aeronave = List(
              List(0, 0, 1, 0, 0, 1),
              List(1, 0, 0, 0, 1, 0)
           )
  
  println("Qtd. de assentos livres da Aeronave: " + assentosLivresAeronave(aeronave)(assentosPorFila))  
  println("Qtd. de assentos ocupados da fila: " + assentosPorFila(aeronave(0))(1))
  println("Assentos continuos livres de uma fila: " + assentosConinuosLivres(aeronave(0)))
//  assentosConinuosLivres(aeronave(0))
  
}