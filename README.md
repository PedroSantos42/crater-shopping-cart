# Você foi escalado para desenvolver uma API Restful usando Java para o controle de carrinho de compras de um grande varejista brasileiro.

## O e-commerce possui um modelo de descontos que tem as seguintes regras:

### 1. Comprando *10 ou mais* produtos do mesmo tipo, cada item recebe um *desconto de 10%*

### 2. Desconto progressivo:
- A partir de *R$1.000,00* em compras é aplicado um desconto de *5%* no valor total;
- A partir de *R$5.000,00* em compras é aplicado um desconto de *7%* no valor total;
- A partir de *R$10.000,00* em compras é aplicado um desconto de *10%* no valor total;

Regularmente a empresa disponibiliza cupons de desconto a empresas parceiras e digital influencers a fim de aumentar a visibilidade da marca, esses *cupons* variam de acordo com a ocasião e *são aplicados de maneira global ao valor do carrinho*.

Os cupons de desconto nunca são cumulativos. No caso da aplicação de *mais de um cupom, o de maior valor deve ser levado em consideração*.

### A aplicação deve permitir o **cadastro de produtos e cupons** além da inserção desses produtos no **carrinho de compras**, o carrinho deve **calcular seu total e subtotal dos itens** (com e sem aplicação dos descontos).