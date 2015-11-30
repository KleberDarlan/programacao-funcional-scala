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
    var assentosLivres:List[Int] = Nil
		fila.zipWithIndex.filter(_._1 == 0).map(_._2)
      .sliding(2).foreach(x => {
          if(x(1) == x(0) + 1)
            x.foreach { x => assentosLivres = x::assentosLivres }
        })

    assentosLivres.distinct.sorted
  }
  
  // 1) D
  // funcao para retornar conjunto formado pelas filas contínuas 
  // de uma aeronave com a maior quantidade de assentos contínuos
  // livres
  def filasContinuasLivres(aeronave: List[List[Int]]) = {
    
  }
  
  // 1) E
  // funcao para retornar aeronave(s) com maior numero de assentos ocupados
  def aeronavesAssentosOcupados(companhia:List[List[List[Int]]]) = {
    
  }
  
  var aeronave = List(
              List(0, 0, 1, 0, 0, 1),
              List(1, 0, 0, 0, 1, 0),
              List(1, 0, 1, 1, 1, 0),
              List(1, 0, 0, 0, 1, 0)
           )
  
  var aeronave2 = List(
              List(0, 0, 1, 0, 0, 1),
              List(1, 0, 1, 1, 1, 0)
           )
  
  var aeronave3 = List(
              List(0, 0, 1, 0, 1, 1),
              List(1, 0, 1, 1, 1, 1)
           )
           
  var companhiaList = List(aeronave, aeronave2, aeronave3)
  
  println("Qtd. de assentos livres da Aeronave: " + assentosLivresAeronave(aeronave)(assentosPorFila))  
  println("Qtd. de assentos ocupados da fila: " + assentosPorFila(aeronave(0))(1))
  println("Assentos continuos livres de uma fila: " + assentosConinuosLivres(aeronave(0)))
  println("Aeronaves com maior n. assent. ocupados: " + aeronavesAssentosOcupados(companhiaList))
}