# Traditional T9
Este manual explica como configurar e usar o Traditional T9 em diferentes cenários. Para instruções de instalação e informações sobre as versões “lite” e “completa”, consulte o [guia de instalação](https://github.com/sspanak/tt9/blob/master/docs/installation.md) no GitHub. Você também pode acessar a [página principal do repositório](https://github.com/sspanak/tt9), que inclui todo o código fonte, um guia para desenvolvedores, a política de privacidade e documentação adicional.

## Configuração Inicial
Após a instalação, primeiro é necessário ativar o Traditional T9 como teclado Android. Para isso, clique no ícone do aplicativo. Se uma ação for necessária, todas as opções, exceto “Configuração Inicial”, estarão desativadas e uma etiqueta “TT9 está desativado” será exibida. Acesse “Configuração Inicial” e ative-o.

_Se o ícone não aparecer imediatamente após a instalação, reinicie seu telefone e ele deverá aparecer. Isso ocorre porque o Android tenta economizar energia não atualizando a lista de aplicativos recém-instalados._

### Uso em um telefone apenas com tela sensível ao toque
Em dispositivos com tela sensível ao toque, recomenda-se desativar o corretor ortográfico do sistema. Ele não pode ser usado durante a digitação com as teclas numéricas, o que permite prolongar a vida útil da bateria ao desativá-lo.

Outro problema é que o corretor ortográfico pode exibir uma janela pop-up “Adicionar uma palavra” que adiciona palavras ao teclado padrão do sistema (geralmente o Gboard) e não ao dicionário do Traditional T9. Para evitar isso, o corretor ortográfico do sistema deve ser desativado.

Se você precisar realizar essa etapa, o item “Corretor ortográfico do sistema” na tela de configuração inicial será ativado. Clique nele para desativar o componente do sistema. Se este item não for visível, não há mais nada a ser feito.

Após concluir a configuração, consulte a seção [Teclado na Tela](#teclado-na-tela) para obter mais dicas.

### Ativação do Modo Preditivo
O Modo Preditivo requer o carregamento de um dicionário de idioma para sugerir palavras. Você pode ativar idiomas e carregar seus dicionários acessando Tela de Configurações → [Idiomas](#opções-de-idioma). Se esquecer de carregar um dicionário, o Traditional T9 o fará automaticamente ao iniciar a digitação. Para mais informações, [veja abaixo](#opções-de-idioma).

#### Notas para telefones de baixo desempenho
O carregamento do dicionário pode sobrecarregar telefones de baixo desempenho. Com a versão "lite" do TT9, isso pode fazer com que o Android encerre a operação. Se o carregamento levar mais de 30 segundos, conecte o carregador ou certifique-se de que a tela permaneça ativa durante o carregamento.

Você pode evitar isso usando a versão “completa”.

#### Observação para Android 13 ou superior
Por padrão, as notificações para aplicativos recém-instalados estão desativadas. Recomenda-se ativá-las. Isso permite que você seja informado sobre atualizações dos dicionários, e, uma vez que escolha instalá-las, o TT9 exibirá o progresso do carregamento. As novas atualizações são publicadas no máximo uma vez por mês, portanto, você não precisa se preocupar com excesso de notificações.

Você pode ativar as notificações indo em Configurações → Idiomas e ativando Notificações de Dicionário.

_Se optar por mantê-las desativadas, o TT9 continuará funcionando sem problemas, mas você terá que gerenciar os dicionários manualmente._

## Atalhos de Teclado

Todos os atalhos de teclado podem ser reconfigurados ou desativados em Configurações → Teclado → Selecionar Atalhos.

### Teclas de Digitação

#### Tecla de sugestão anterior (padrão: seta esquerda):
Seleciona a sugestão de palavra ou letra anterior.

#### Tecla de próxima sugestão (padrão: seta direita):
Seleciona a sugestão de palavra ou letra seguinte.

#### Tecla de filtro de sugestões (padrão: seta para cima):
_Modo Preditivo apenas._

- **Toque simples**: filtra a lista de sugestões, deixando apenas as que começam com a palavra atual. Por exemplo, digite "remin" e toque em Filtrar para manter apenas palavras que começam com "remin": "remin", "remind", "reminds", "reminded", "reminding", etc.
- **Toque duplo**: amplia o filtro para a sugestão completa. Por exemplo, digite "remin" e toque duas vezes em Filtrar para filtrar por "remind". Você pode continuar ampliando o filtro até obter a palavra mais longa do dicionário.

O filtro também é útil para digitar palavras desconhecidas. Por exemplo, para digitar "Anakin", comece com "A", depois toque em Filtrar para ocultar "B" e "C". Em seguida, toque na tecla 6. Com o filtro ativado, isso sugerirá todas as combinações possíveis para 1+6: "A..." + "m", "n", "o". Selecione "n" e toque em Filtrar para validar sua seleção e obter "An". Depois, toque na tecla 2 para obter "An..." + "a", "b", "c". Continue até obter "Anakin".

Quando o filtro está ativado, o texto de base fica em negrito e itálico.

#### Tecla Limpar Filtro (padrão: seta para baixo):
_Modo Preditivo apenas._

Limpa o filtro de sugestões, se aplicado.

#### Tecla central (OK ou Enter):
- Quando sugestões são exibidas, insere a sugestão selecionada.
- Caso contrário, executa a ação padrão do aplicativo (por exemplo, enviar uma mensagem, acessar uma URL, ou inserir uma quebra de linha).

_**Nota**: Cada aplicativo decide qual função executar ao pressionar OK, e o TT9 não tem controle sobre esse comportamento._

_**Nota 2**: Para enviar mensagens com OK em aplicativos de mensagens, você deve ativar a configuração “Enviar com Enter” ou uma configuração semelhante. Se o aplicativo não tiver tal configuração, provavelmente ele não suporta o envio por este método. Nesse caso, use o aplicativo KeyMapper do [Play Store](https://play.google.com/store/apps/details?id=io.github.sds100.keymapper) ou [F-droid](https://f-droid.org/packages/io.github.sds100.keymapper/). Ele pode detectar aplicativos de mensagens e simular uma tecla no botão de envio da mensagem. Consulte o [guia de início rápido](https://docs.keymapper.club/quick-start/) para mais informações._

#### Tecla 0:
- **No modo 123:**
  - **Toque**: insere "0".
  - **Pressione e segure**: insere caracteres especiais/matemáticos.
  - **Pressione e segure "0", depois pressione Shift (padrão: pressione e segure "0", depois "*")**: insere símbolos monetários.
- **No modo ABC:**
  - **Toque**: insere espaço, nova linha, ou caracteres especiais/matemáticos.
  - **Pressione e segure**: insere "0".
  - **Pressione "0", depois pressione Shift (padrão: pressione "0", "*")**: insere símbolos monetários.
- **No modo Preditivo:**
  - **Toque**: insere espaço, nova linha, ou caracteres especiais/matemáticos.
  - **Toque duas vezes**: insere o caractere atribuído nas configurações do modo Preditivo (padrão: ".").
  - **Pressione e segure**: insere "0".
  - **Pressione "0", depois pressione Shift (padrão: pressione "0", "✱")**: insere símbolos monetários.
- **No modo Cheonjiin (Coreano):**
  - **Pressione:** insere "ㅇ" e "ㅁ".
  - **Segure:** insere espaço, nova linha, "0" ou caracteres especiais/matemáticos.
  - **Segure "0", depois pressione Shift (Padrão: segure "0", pressione "✱")**: insere símbolos monetários.


#### Tecla 1:
- **No modo 123:**
  - **Toque**: insere "1".
  - **Pressione e segure**: insere caracteres de pontuação.
- **No modo ABC:**
  - **Toque**: insere caracteres de pontuação.
  - **Pressione e segure**: insere "1".
- **No modo Preditivo:**
  - **Toque**: insere caracteres de pontuação.
  - **Toque múltiplo**: insere emojis.
  - **Toque 1-1-3**: insere emojis adicionados (é necessário adicionar usando a [tecla Adicionar Palavra](#tecla-adicionar-palavra)).
  - **Pressione e segure**: insere "1".
- **No modo Cheonjiin (Coreano):**
  - **Pressione:** insere a vogal "ㅣ".
  - **Pressione e segure:** insere caracteres de pontuação.
  - **Segure, depois pressione:** insere emojis.
  - **Segure 1, pressione 1, depois 3:** insere emojis adicionados (é necessário adicionar usando a [tecla Adicionar Palavra](#tecla-adicionar-palavra)).

#### Teclas de 2 a 9:
- **No modo 123**: insere o número correspondente.
- **No modo ABC e Preditivo**: insere uma letra ou pressione e segure para inserir o número correspondente.

### Teclas de Função

#### Tecla Adicionar Palavra:
Adiciona uma nova palavra ao dicionário para o idioma atual.

Você também pode adicionar novos emojis, acessíveis ao pressionar 1-1-3. Independentemente do idioma selecionado, todos os emojis estão disponíveis em todos os idiomas.

#### Tecla Voltar (Voltar, Excluir ou Retornar):
Apaga texto.

Se seu telefone tiver uma tecla “Excluir” ou “Apagar” dedicada, você não precisa configurar nada, a menos que queira outro botão Voltar. Nesse caso, a opção vazia: “--” será automaticamente selecionada.

Em telefones com uma tecla combinada “Excluir/Voltar”, essa tecla será selecionada automaticamente. No entanto, você pode atribuir a função "Voltar" a outro botão para que "Retornar" tenha apenas uma função de navegação.

_**Nota**: Usar “Voltar” como retorno não funciona em todos os aplicativos, especialmente no Firefox, Spotify e Termux, pois esses aplicativos podem redefinir a função da tecla. Como "Voltar" tem um papel especial no Android, seu uso é limitado pelo sistema._

_**Nota 2**: Manter a tecla "Voltar" pressionada sempre aciona a ação padrão do sistema (por exemplo, exibir a lista de aplicativos em execução)._

_Nesses casos, você pode atribuir outra tecla (todas as outras estão disponíveis) ou usar o retorno de tela._

#### Tecla de Alterar o Modo de Entrada (padrão: pressione #):
Altera o modo de entrada (abc → Preditivo → 123).

_O modo Preditivo não está disponível em campos de senha._

_Em campos apenas numéricos, mudar de modo é impossível. Neste caso, a tecla retorna à sua função padrão (ou seja, digitar "#")._

#### Tecla de Editar Texto:
Exibe o painel de edição de texto, permitindo selecionar, recortar, copiar e colar texto. Você pode fechar o painel pressionando a tecla "✱" novamente ou, na maioria dos aplicativos, pressionando o botão Voltar. Mais detalhes disponíveis [abaixo](#edição-de-texto).

#### Tecla Próximo Idioma (padrão: pressione e segure #):
Seleciona o próximo idioma quando vários idiomas estão ativados nas Configurações.

#### Tecla Selecionar Teclado:
Abre a caixa de diálogo de mudança de teclado do Android, onde você pode escolher entre todos os teclados instalados.

#### Tecla Shift (padrão: pressione *):
- **Durante a digitação de texto**: alterna entre maiúsculas e minúsculas.
- **Durante a digitação de caracteres especiais com a tecla 0**: exibe o próximo grupo de caracteres.

#### Tecla Exibir Configurações:
Abre a tela de configuração das Configurações, onde você pode escolher os idiomas de entrada, configurar atalhos de teclado, modificar a aparência do aplicativo, ou melhorar a compatibilidade com seu telefone.

#### Tecla Entrada por Voz:
Ativa a entrada por voz para telefones compatíveis. Consulte [abaixo](#entrada-por-voz) para mais informações.

#### Tecla Lista de Comandos / Paleta de Comandos / (padrão: pressione e segure ✱):
Exibe uma lista de todos os comandos (ou funções).

Muitos telefones têm apenas duas ou três teclas “livres” que podem ser usadas como atalhos. No entanto, o Traditional T9 possui muito mais funções, então é impossível ter todas elas no teclado. A Paleta de Comandos resolve esse problema permitindo invocar funções adicionais por meio de combinações de teclas.

Aqui está uma lista de comandos possíveis:
- **Exibir Tela de Configurações (Combinação padrão: pressione e segure ✱, tecla 1)**. Igual ao pressionar [Exibir Configurações](#tecla-exibir-configurações).
- **Adicionar Palavra (Combinação padrão: pressione e segure ✱, tecla 2)**. Igual ao pressionar [Adicionar Palavra](#tecla-adicionar-palavra).
- **Entrada por Voz (Combinação padrão: pressione e segure ✱, tecla 3)**. Igual ao pressionar [Entrada por Voz](#tecla-entrada-por-voz).
- **Editar Texto (Combinação padrão: pressione e segure ✱, tecla 5)**. Igual ao pressionar [Editar Texto](#tecla-de-editar-texto).
- **Selecionar um Teclado Diferente (Combinação padrão: pressione e segure ✱, tecla 8)**. Igual ao pressionar [Selecionar Teclado](#tecla-selecionar-teclado).

_Esta tecla não faz nada quando a Exibição de Tela está configurada para “Teclado Virtual”, pois todas as teclas para todas as funções possíveis já estão disponíveis na tela._

## Entrada por Voz
A função de entrada por voz permite entrada por fala-para-texto, semelhante ao Gboard. Como todos os outros teclados, o Traditional T9 não realiza o reconhecimento de voz por si só; ele solicita que seu telefone faça isso.

_O botão de Entrada por Voz fica oculto em dispositivos que não o suportam._

### Dispositivos Suportados
Em dispositivos com Serviços Google, ele usará a infraestrutura Google Cloud para converter suas palavras em texto. É necessário conectar-se a uma rede Wi-Fi ou habilitar dados móveis para que esse método funcione.

Em dispositivos sem Google, se houver um aplicativo de assistente de voz ou o teclado nativo suportar a entrada por voz, o recurso disponível será usado para o reconhecimento de voz. No entanto, este método é consideravelmente menos eficaz que o Google. Não funcionará em ambientes barulhentos e, geralmente, reconhecerá apenas frases simples, como: "abrir calendário" ou "tocar música" e similares. A vantagem é que funcionará offline.

Outros celulares sem Google geralmente não suportam entrada por voz. Celulares chineses não possuem capacidades de reconhecimento de fala devido às políticas de segurança chinesas. Nesses celulares, pode ser possível ativar o suporte de entrada por voz instalando o aplicativo Google, nome do pacote: "com.google.android.googlequicksearchbox".

## Teclado na Tela
Em telefones apenas com tela sensível ao toque, um teclado completo na tela está disponível e será ativado automaticamente. Se, por algum motivo, seu telefone não foi detectado como tendo touchscreen, ative-o indo em Configurações → Aparência → Layout na Tela e selecione "Teclado Numérico Virtual".

Se você tiver tanto um touchscreen quanto um teclado físico e preferir ter mais espaço na tela, desative as teclas de software em Configurações → Aparência.

Recomenda-se também desativar o comportamento especial da tecla "Voltar" funcionando como "Backspace". Isso é útil apenas para teclados físicos. Geralmente, isso acontecerá automaticamente, mas se não, vá para Configurações → Teclado → Selecionar Teclas de Atalho → Tecla Backspace e selecione a opção "--".

### Visão Geral das Teclas Virtuais
### Visão Geral das Teclas Virtuais
O teclado na tela funciona da mesma forma que o teclado numérico de um telefone com teclas físicas. Se uma tecla oferece uma única função, ela terá um único rótulo (ou ícone) indicando essa função. Se a tecla tiver uma função secundária ativada ao pressionar e segurar, ela terá dois rótulos (ou ícones).

Abaixo está uma descrição das teclas com mais de uma função.

#### Tecla F2 Direita (segunda tecla de cima para baixo na coluna direita)
_Somente no modo preditivo._

- **Pressionar:** Filtra a lista de sugestões. Veja [acima](#tecla-de-filtro-de-sugestões-padrão-seta-para-cima) como funciona o filtro de palavras.
- **Pressionar e segurar:** Limpa o filtro, se ativo.

#### Tecla F3 Direita (terceira tecla de cima para baixo na coluna direita)
- **Pressionar:** Abre as opções de copiar, colar e editar texto.
- **Pressionar e segurar:** Ativa a entrada por voz.

#### Tecla F4 Esquerda (a tecla inferior esquerda)
- **Pressionar:** Alterna os modos de entrada (abc → Preditivo → 123).
- **Pressionar e segurar:** Seleciona o próximo idioma, se vários idiomas estiverem ativados nas configurações.
- **Deslizar horizontalmente:** Alterna para o último teclado usado, diferente do TT9.
- **Deslizar verticalmente:** Abre o diálogo de troca de teclado do Android, onde você pode selecionar entre todos os teclados instalados.

_A tecla exibirá um pequeno ícone de globo se você tiver ativado mais de um idioma em Configurações → Idiomas. O ícone indica que é possível mudar o idioma pressionando e segurando a tecla._

### Redimensionar o Painel do Teclado Durante a Digitação
Em alguns casos, você pode achar que o Teclado Virtual está ocupando muito espaço na tela, impedindo que você veja o que está digitando ou alguns elementos do aplicativo. Se for o caso, redimensione-o mantendo pressionado e arrastando a tecla de Configurações/Paleta de Comandos ou arrastando a Barra de Status (onde o idioma atual ou modo de digitação são exibidos). Quando a altura ficar muito pequena, o layout mudará automaticamente para "Teclas de Função" ou "Somente Lista de Sugestões". Ao redimensionar para cima, o layout mudará para "Teclado Virtual". Você também pode dar um duplo toque na barra de status para minimizar ou maximizar instantaneamente.

_Redimensionar o Traditional T9 também redimensiona o aplicativo atual. Fazer ambos é computacionalmente muito caro e pode causar cintilação ou travamento em muitos celulares, inclusive de ponta._

### Alterando a Altura das Teclas
Também é possível alterar a altura das teclas na tela. Para fazer isso, vá para Configurações → Aparência → Altura das Teclas na Tela e ajuste conforme desejar.

A configuração padrão de 100% é um bom equilíbrio entre tamanho de botão utilizável e espaço ocupado na tela. No entanto, se você tiver dedos grandes, pode querer aumentar um pouco a configuração. Caso utilize o TT9 em uma tela maior, como um tablet, pode querer reduzir.

_Se o espaço disponível na tela for limitado, o TT9 ignorará essa configuração e reduzirá automaticamente sua altura para deixar espaço suficiente para o aplicativo atual._

## Edição de Texto
No painel de Edição de Texto, você pode selecionar, recortar, copiar e colar texto, semelhante ao que é possível em um teclado de computador. Para sair da Edição de Texto, pressione a tecla "✱" ou a tecla Voltar (exceto em navegadores, Spotify e alguns outros aplicativos). Ou pressione a tecla de letras no Teclado na Tela.

Abaixo está uma lista dos comandos de texto possíveis:
1. Selecionar o caractere anterior (como Shift+Esquerda em um teclado de computador)
2. Selecionar nenhum
3. Selecionar o próximo caractere (como Shift+Direita)
4. Selecionar a palavra anterior (como Ctrl+Shift+Esquerda)
5. Selecionar tudo
6. Selecionar a próxima palavra (como Ctrl+Shift+Direita)
7. Recortar
8. Copiar
9. Colar

Para facilitar a edição, as teclas backspace, espaço e OK também estão ativas.

## Tela de Configurações
Na tela de Configurações, você pode escolher idiomas para digitação, configurar atalhos do teclado, mudar a aparência do aplicativo ou melhorar a compatibilidade com seu telefone.

### Como acessar as Configurações?

#### Método 1
Clique no ícone de inicialização do Traditional T9.

#### Método 2 (usando uma tela sensível ao toque)
- Toque em um campo de texto ou número para ativar o TT9.
- Use o botão de engrenagem na tela.

#### Método 3 (usando um teclado físico)
- Comece a digitar em um campo de texto ou número para ativar o TT9.
- Abra a lista de comandos usando o botão de ferramentas na tela ou pressionando a tecla de atalho atribuída [Padrão: Segure ✱].
- Pressione a tecla 2.

### Navegando nas Configurações
Se você tem um dispositivo com teclado físico, há duas formas de navegar nas Configurações.

1. Use as teclas Cima/Baixo para rolar e OK para abrir ou ativar uma opção.
2. Pressione as teclas 1-9 para selecionar a opção correspondente e pressione-as duas vezes para abrir/ativar. O duplo toque funcionará independentemente de onde você esteja na tela. Por exemplo, mesmo se estiver no topo, ao pressionar duas vezes a tecla 3, a terceira opção será ativada. Finalmente, a tecla 0 é um atalho conveniente para rolar até o final, mas não abre a última opção.

### Opções de Idioma

#### Carregar um Dicionário
Depois de habilitar um ou mais idiomas novos, você deve carregar os respectivos dicionários para o Modo Preditivo. Uma vez carregado, o dicionário permanecerá até que você use uma das opções de "excluir". Isso significa que você pode habilitar e desabilitar idiomas sem recarregar seus dicionários sempre. Basta fazer isso uma vez, apenas na primeira vez.

Isso também significa que, se você precisar começar a usar o idioma X, poderá desativar com segurança todos os outros idiomas, carregar apenas o dicionário X (e economizar tempo!) e, em seguida, reativar todos os idiomas que usava antes.

Lembre-se de que recarregar um dicionário redefinirá a popularidade das sugestões para os padrões de fábrica. No entanto, não há motivo para preocupação. Na maioria dos casos, você verá pouca ou nenhuma diferença na ordem das sugestões, a menos que use palavras incomuns com frequência.

#### Carregamento Automático de Dicionário

Se você pular ou esquecer de carregar um dicionário na tela de Configurações, isso acontecerá automaticamente mais tarde, ao abrir um aplicativo onde é possível digitar e alternar para o Modo Preditivo. Você será solicitado a esperar até que o processo seja concluído e, após isso, poderá começar a digitar imediatamente.

Se você excluir um ou mais dicionários, eles NÃO serão recarregados automaticamente. Você terá que fazer isso manualmente. Somente dicionários de idiomas recentemente habilitados carregarão automaticamente.

#### Excluindo um Dicionário
Se você parou de usar os idiomas X ou Y, pode desativá-los e usar "Excluir Não Selecionados" para liberar espaço de armazenamento.

Para excluir tudo, independentemente da seleção, use "Excluir Todos".

Em todos os casos, as palavras adicionadas por você serão preservadas e restauradas assim que você recarregar o dicionário respectivo.

#### Palavras Adicionadas
A opção "Exportar" permite exportar todas as palavras adicionadas, para todos os idiomas, incluindo qualquer emoji adicionado, para um arquivo CSV. Em seguida, você pode usar o arquivo CSV para melhorar o Traditional T9! Acesse o GitHub e compartilhe as palavras em uma [nova issue](https://github.com/sspanak/tt9/issues) ou [pull request](https://github.com/sspanak/tt9/pulls). Após revisão e aprovação, elas serão incluídas na próxima versão.

Com "Importar", você pode importar um CSV exportado anteriormente. No entanto, há algumas restrições:
- Você só pode importar palavras que consistam em letras. Apóstrofos, hífens, outras pontuações ou caracteres especiais não são permitidos.
- Emojis não são permitidos.
- Um arquivo CSV pode conter no máximo 250 palavras.
- É possível importar até 1000 palavras, o que significa que você pode importar no máximo 4 arquivos X 250 palavras. Além desse limite, ainda é possível adicionar palavras ao digitar.

Usando "Excluir", você pode buscar e deletar palavras com erros ortográficos ou outras que não deseja no dicionário.

### Opções de Compatibilidade
Para diversos aplicativos ou dispositivos, é possível habilitar opções especiais, que farão o Traditional T9 funcionar melhor com eles. Você pode encontrá-las ao final de cada tela de configurações, na seção Compatibilidade.

#### Método alternativo de rolagem de sugestões
_Em: Configurações → Aparência._

Em alguns dispositivos, no Modo Preditivo, pode ser que você não consiga rolar a lista até o final, ou precise rolar para trás e para frente várias vezes até que a última sugestão apareça. O problema ocorre às vezes no Android 9 ou anterior. Habilite a opção se estiver enfrentando esse problema.

#### Sempre no topo
_Em: Configurações → Aparência._

Em alguns celulares, especialmente Sonim XP3plus (XP3900), o Traditional T9 pode não aparecer ao começar a digitar ou pode ser parcialmente coberto pelas teclas de navegação na tela. Em outros casos, podem aparecer barras brancas ao redor. O problema pode ocorrer em um aplicativo específico ou em todos. Para evitar isso, ative a opção "Sempre no Topo".

#### Proteção contra repetição de teclas
_Em: Configurações → Teclado._

Os telefones CAT S22 Flip e Qin F21 são conhecidos por seus teclados de baixa qualidade, que se degradam rapidamente ao longo do tempo e começam a registrar múltiplos cliques para uma única pressão de tecla. Você pode notar isso ao digitar ou navegar nos menus do telefone.

Para celulares CAT, a configuração recomendada é de 50-75 ms. Para o Qin F21, tente com 20-30 ms. Se o problema persistir, aumente o valor um pouco, mas tente mantê-lo o mais baixo possível.

_**Nota:** Quanto maior o valor configurado, mais lento você precisará digitar. O TT9 ignorará pressões de tecla muito rápidas._

_**Nota 2:** Além do problema acima, os celulares Qin também podem falhar ao detectar pressões longas. Infelizmente, neste caso, nada pode ser feito._

#### Painéis de figurinhas e emojis do Telegram/Snapchat não abrem
Isso ocorre se você estiver usando um dos layouts de tamanho reduzido. Atualmente, não há uma correção permanente, mas você pode usar o seguinte procedimento:
- Vá para Configurações → Aparência e ative o Teclado Numérico na Tela.
- Volte para o chat e clique no botão de emoji ou de figurinhas. Agora eles aparecerão.
- Agora você pode voltar para as configurações e desativar o teclado numérico na tela. Os painéis de emoji e figurinhas permanecerão acessíveis até que você reinicie o aplicativo ou o telefone.

#### O Traditional T9 não aparece imediatamente em alguns aplicativos
Se você abriu um aplicativo onde pode digitar, mas o TT9 não aparece automaticamente, basta começar a digitar para que ele apareça. Alternativamente, pressionar as teclas de atalho para mudar [o modo de entrada](#tecla-de-alterar-o-modo-de-entrada-padrão-pressione) ou o [idioma](#tecla-próximo-idioma-padrão-pressione-e-segure) também pode fazer o TT9 aparecer, caso esteja oculto.

Em alguns dispositivos, o TT9 pode permanecer invisível, não importando o que você faça. Nesses casos, você precisará ativar a opção [Sempre no Topo](#sempre-no-topo).

**Explicação longa.** O motivo para esse problema é que o Android foi projetado principalmente para dispositivos touchscreen. Portanto, ele espera que você toque no campo de texto/número para exibir o teclado. É possível fazer o TT9 aparecer sem essa confirmação, mas, em alguns casos, o Android pode esquecer de ocultá-lo quando necessário. Por exemplo, ele pode permanecer visível após você discar um número de telefone ou após enviar texto em um campo de busca.

Por esses motivos, para manter os padrões esperados do Android, o controle está em suas mãos. Basta pressionar uma tecla para "tocar" na tela e continuar digitando.

#### No Qin F21 Pro, segurar a tecla 2 ou 8 aumenta ou diminui o volume em vez de digitar um número
Para mitigar esse problema, vá para Configurações → Aparência e ative "Ícone de Status". O TT9 deve detectar o Qin F21 e habilitar as configurações automaticamente, mas, caso a detecção automática falhe, ou você tenha desativado o ícone por algum motivo, é necessário mantê-lo ativo para que todas as teclas funcionem corretamente.

**Explicação longa.** O Qin F21 Pro (e possivelmente o F22) possui um aplicativo de atalho que permite atribuir funções de Aumentar e Diminuir Volume às teclas numéricas. Por padrão, o gerenciador de atalhos está ativado, e segurar a tecla 2 aumenta o volume, enquanto segurar a tecla 8 o diminui. No entanto, quando não há ícone de status, o gerenciador assume que nenhum teclado está ativo e ajusta o volume, em vez de deixar o Traditional T9 gerenciar a tecla e digitar um número. Então, ativar o ícone apenas ignora o gerenciador de atalhos, e tudo funciona normalmente.

#### Problemas gerais em telefones Xiaomi
A Xiaomi introduziu várias permissões não padrão em seus celulares, o que impede o teclado virtual na tela do Traditional T9 de funcionar corretamente. Mais especificamente, as teclas "Exibir Configurações" e "Adicionar Palavra" podem não executar suas funções respectivas. Para corrigir isso, você deve conceder as permissões "Exibir janela pop-up" e "Exibir janela pop-up em segundo plano" ao TT9 nas configurações do seu telefone. [Este guia](https://parental-control.flashget.com/how-to-enable-display-pop-up-windows-while-running-in-the-background-on-flashget-kids-on-xiaomi) para outro aplicativo explica como fazer isso.

É também altamente recomendável conceder a permissão "Notificação Permanente". Isso é semelhante à permissão "Notificações" introduzida no Android 13. Veja [acima](#observação-para-android-13-ou-superior) para mais informações sobre por que você precisa dela.

_Os problemas com Xiaomi foram discutidos nesta [issue do GitHub](https://github.com/sspanak/tt9/issues/490)._

#### A Entrada por Voz demora muito para parar
Esse é [um problema conhecido](https://issuetracker.google.com/issues/158198432) no Android 10 que o Google nunca corrigiu. Não é possível mitigar isso pelo lado do TT9. Para parar a operação de Entrada por Voz, permaneça em silêncio por alguns segundos. O Android desliga o microfone automaticamente quando não detecta nenhuma fala.

## Perguntas Frequentes

#### Você não pode adicionar a funcionalidade X?
Não.

Cada pessoa tem suas preferências. Alguns querem teclas maiores, outros em uma ordem diferente, alguns querem uma tecla de atalho para digitar ".com", e outros sentem falta do seu antigo telefone ou teclado. Mas, por favor, entenda que estou trabalhando nisso voluntariamente no meu tempo livre. É impossível atender a milhares de pedidos diferentes, alguns dos quais até se contradizem.

Henry Ford disse uma vez: "O cliente pode ter o carro da cor que quiser, desde que seja preto." Da mesma forma, o Traditional T9 é simples, eficaz e gratuito, mas o que você vê é o que você recebe.

#### Você não pode torná-lo mais parecido com Sony Ericsson ou Xperia, Nokia C2, Samsung ou outro teclado de software?
Não.

O Traditional T9 não foi feito para ser um substituto ou um aplicativo clone. Ele tem um design único, inspirado principalmente no Nokia 3310 e 6303i. E, embora capture a essência dos clássicos, ele oferece sua própria experiência, que não replica exatamente nenhum dispositivo.

#### Você deveria copiar o Touchpal, é o melhor teclado do mundo!
Não, eu não deveria. Veja os pontos anteriores.

O Touchpal costumava ser o melhor teclado em 2015, quando não tinha concorrência real. No entanto, as coisas mudaram desde então. Veja a comparação lado a lado entre Traditional T9 e Touchpal:

_**Traditional T9**_
- Respeita sua privacidade.
- Não contém anúncios e é gratuito.
- Suporta uma ampla variedade de dispositivos: celulares básicos e TVs com teclados físicos, além de smartphones e tablets apenas com tela sensível ao toque.
- Oferece um layout T9 de 12 teclas adequado para cada idioma.
- Fornece sugestões de palavras aprimoradas. Por exemplo, se você tentar digitar expressões com textônimos como "go in", ele aprenderá a não sugerir "go go" ou "in in", mas sim a expressão significativa que você tinha em mente.
- Tudo o que você digita permanece no seu telefone. Nenhuma informação é enviada para lugar nenhum.
- É de código aberto, permitindo que você revise todo o código-fonte e os dicionários, contribua para o projeto para torná-lo melhor (muitos usuários ajudaram corrigindo bugs e adicionando novos idiomas e traduções) ou até mesmo crie uma versão modificada com base em suas preferências e visão.
- Tem um design limpo e altamente legível que se integra ao sistema. Não há elementos desnecessários que distraiam, permitindo que você se concentre na digitação.
- A velocidade de carregamento do dicionário é lenta.

_**Touchpal**_
- Solicita agressivamente acesso a todo o seu dispositivo e contatos; grava arquivos aleatórios em qualquer lugar; no final, foi banido da Play Store porque se comportava como um vírus.
- Está cheio de anúncios.
- Suporta apenas dispositivos com tela sensível ao toque.
- Não é um verdadeiro teclado T9. Oferece um layout T9 apenas em alguns idiomas. Além disso, alguns layouts estão incorretos (por exemplo, no layout búlgaro falta uma letra e algumas letras estão trocadas entre a tecla 8 e a tecla 9).
- Ao digitar textônimos consecutivos, ele sugere apenas a última palavra selecionada. Por exemplo, se você tentar digitar "go in", ele mostrará apenas "go go" ou "in in".
- Sugestões baseadas em nuvem poderiam ser usadas para melhorar a precisão. No entanto, para que isso funcione, você e todos os outros usuários precisariam enviar tudo o que digitam para os servidores do Touchpal para processamento.
- Código fechado. Não há como verificar o que ele faz em segundo plano.
- Inclui muitos temas, cores, GIFs e outras distrações que não têm relação com a digitação.
- A velocidade de carregamento do dicionário é rápida. O Touchpal vence neste ponto.

Se você discorda ou deseja explicar seu ponto de vista, participe da [discussão aberta](https://github.com/sspanak/tt9/issues/647) no GitHub. Apenas lembre-se de ser respeitoso com os outros. Postagens de ódio não serão toleradas.

#### Preciso usar um layout QWERTY (apenas em dispositivos touchscreen)
O Traditional T9 é um teclado T9 e, como tal, não fornece um layout no estilo QWERTY.

Se você ainda está aprendendo a usar o T9 e precisa mudar de volta ocasionalmente, ou acha mais conveniente digitar novas palavras usando o QWERTY, deslize a tecla F4 Esquerda para cima para alternar para um teclado diferente. Veja a [visão geral das teclas virtuais](#visão-geral-das-teclas-virtuais) para mais informações.

A maioria dos outros teclados permite alternar de volta para o Traditional T9 segurando a barra de espaço ou a tecla de "mudar idioma". Verifique o respectivo manual ou guia do teclado para mais informações.

#### Não consigo mudar o idioma em um telefone com tela sensível ao toque
Primeiro, certifique-se de que ativou todos os idiomas desejados em Configurações → Idiomas. Em seguida, pressione e segure a [tecla F4 esquerda](#tecla-f4-esquerda-a-tecla-inferior-esquerda) para mudar o idioma.