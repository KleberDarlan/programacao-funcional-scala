package funcoes

object companhia extends App {

  // 1) A
  // funcao que retorna assentos livres/ocupados de uma aeronave
  // passando uma aeronave e uma funcao por parametro
  var assentosAeronave = (aeronave:List[List[Int]]) => (f:(List[Int]) => Int) => aeronave.map(x => f(x)).sum
  
  // 1) B
  // funcao para retornar numero de assentos livres
  // passando uma fila de assentos por parametro
  var assentosLivresPorFila = (lista:List[Int]) => lista.filter(_ == 0).size
  
  // funcao para retornar assentos ocupados por fila
  var assentosOcupadosPorFila = (lista:List[Int]) => lista.filter(_ == 1).size
  
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
  var filasContinuasLivres = (aeronave: List[List[Int]]) => aeronave.map(assentosConinuosLivres(_)).zipWithIndex.filter(!_._1.isEmpty).map(_._2)
  
  // 1) E
  // funcao para retornar aeronave(s) com maior numero de assentos ocupados
  def aeronavesAssentosOcupados(companhia:List[List[List[Int]]]) = {
    val parte = companhia.map(x => assentosAeronave(x)(assentosOcupadosPorFila))
    parte.zipWithIndex.filter(_._1 == parte.max).map(_._2)
  }
  
  // 2) A
  // funcao para retornar retornar  o  valor 
  // arrecadado com a venda de todos os assentos da aeronave
  // passando uma aeronave e o valor da Classe economica
  def arrecadacao(aeronave: List[List[Int]], valor:Double) = {
		val economica = calculaValor((qtdAssentos(aeronave) * 0.8).round)(valor)
    val primeira = calculaValor((qtdAssentos(aeronave) * 0.05).round)(economica * 6)
    val executiva = calculaValor((qtdAssentos(aeronave) * 0.15).round)(primeira/2)
    
    aculmulaArrecadacao(economica)(aculmulaArrecadacao(executiva)(primeira))
  }
  
  // funcao para auxiliar no calculo da arrecadacao  
  var calculaValor = (qtd: Long) => (valor: Double) => valor * qtd
  
  // funcao para acumular valores
  var aculmulaArrecadacao = (v1: Double) => (v2: Double) => v1 + v2
  
  // funcao para retornar quantidade de assentos de uma aeronave
  var qtdAssentos = (aeronave: List[List[Int]]) => aeronave.map(x => x.size).sum
  
  var aeronave = List(
              List(0, 0, 1, 1, 0, 0),
              List(1, 0, 0, 0, 1, 0),
              List(1, 0, 1, 1, 1, 0),
              List(1, 0, 0, 1, 1, 0),
              List(1, 1, 1, 0, 0, 0),
              List(1, 0, 0, 0, 1, 0)
           )
  
  var aeronave2 = List(
              List(0, 0, 1, 0, 0, 1),
              List(1, 0, 0, 0, 1, 0),
              List(1, 0, 1, 1, 1, 0),
              List(1, 0, 0, 1, 1, 0),
              List(1, 1, 1, 0, 0, 0),
              List(1, 0, 1, 1, 1, 0)
           )
  
  var aeronave3 = List(
              List(1, 0, 0, 0, 1, 0),
              List(1, 0, 0, 1, 1, 0),
              List(1, 1, 1, 0, 0, 0),
              List(1, 0, 1, 1, 1, 0),
              List(0, 0, 1, 0, 1, 1),
              List(1, 0, 1, 1, 1, 1)
           )
var aeronave4 = List(
              List(0, 0, 0, 1, 1, 0),
              List(1, 0, 1, 1, 1, 0),
              List(0, 0, 1, 0, 1, 1),
              List(1, 0, 0, 1, 1, 0),
              List(1, 1, 1, 0, 0, 0),
              List(1, 0, 1, 1, 1, 1)
           )
           
  var companhiaList = List(aeronave, aeronave2, aeronave3, aeronave4)
  
  println("Qtd. de assentos livres da Aeronave: " + assentosAeronave(aeronave)(assentosLivresPorFila))  
  println("Qtd. de assentos ocupados da fila: " + assentosOcupadosPorFila(aeronave(0)))
  println("Assentos continuos livres de uma fila: " + assentosConinuosLivres(aeronave(0)))
  println("Filas continuas com assentos cont. livres: " + filasContinuasLivres(aeronave))
  println("Aeronaves com maior n. assent. ocupados: " + aeronavesAssentosOcupados(companhiaList))
  println("Arrecadacao total: " + arrecadacao(aeronave, 100))
}