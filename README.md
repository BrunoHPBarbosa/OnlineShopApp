# Online Shop App

Create a native android app, using Firebase.


## :movie_camera: Video
<img src="https://github.com/user-attachments/assets/ad14a11f-0152-485e-9b44-c3a3b8d7e5f1" width="250">&emsp;<img src="https://github.com/user-attachments/assets/b78beb0b-35da-4517-b19a-979558485dc5" width="250">&emsp;<img src="https://github.com/user-attachments/assets/18f16fed-ef33-4a1a-bde0-b5473f7d5e32" width="250">&emsp;<img src="https://github.com/user-attachments/assets/dcc701e6-145b-46be-973b-54cf01181448" width="250">

## :camera_flash: Screenshots
<img src="https://github.com/user-attachments/assets/d24f28d2-59fa-4c36-b45a-69c1c22ab4f9" width="250">&emsp;
<img src="https://github.com/user-attachments/assets/cd205a05-cdf6-498f-8d41-8de9877c4262" width="250">&emsp;
<img src="https://github.com/user-attachments/assets/81c4e84b-217e-4569-95ee-22b01cdd967f" width="250">&emsp;
<img src="https://github.com/user-attachments/assets/62b7a2c6-3f52-4f82-8ca8-a2a7bbe71891" width="250">&emsp;



🛠️ Technologies used

- Kotlin
- Clean Architecture
- MVVM
- Retrofit
- Dagger Hilt
- Coroutines
- Picasso
- Splash Screen
- Shimmer Effect loading
- Flow
- State Flow
- Jetpack Components (ViewBinding, Navigation Components)

  * Clean Architecture:
    - Separação de conceitos;
    - Interface com base em modelos de dados;
    - Única fonte de informações;
    - Fonte: https://developer.android.com/topic/architecture?hl=pt-br
   
      * MVVM:
    - Separação de responsabilidades;
    - Facilidade de manutenção;
    - Testabilidade.
   
     
      * Retrofit:
  - Biblioteca para se conectar a um serviço REST da Web e receber uma resposta.
  - Fonte: https://square.github.io/retrofit.
 
    * Serialization
  - Analisa a resposta JSON em um objeto de dado
  - Fonte: https://kotlinlang.org/docs/serialization.html#0
 
    * Dagger Hilt
  - Biblioteca de injeção de dependência para Android que reduz a injeção manual de código boilerplate no projeto, oferecendo contêineres para cada classe do Android e gerenciando os ciclos de vida de cada uma automaticamente. 
  - Fonte: https://developer.android.com/training/dependency-injection/hilt-android?hl=pt-br
 
    * Coroutines
  - Padrão de projeto de simultaneidade para simplificar o código que é executado de forma assíncrona. As corrotinas ajudam a gerenciar tarefas de longa duração que podem bloquear a linha de execução principal e fazer com que seu app pare de responder.
  - Fonte: https://developer.android.com/kotlin/coroutines?hl=pt-br
 
* Flow 
  - Em corrotinas, um fluxo é um tipo que pode emitir vários valores sequencialmente. Conceitualmente, um fluxo é um stream de dados que pode ser computado de forma assíncrona.
  - Fonte:https://developer.android.com/kotlin/flow?hl=pt-br
  - 
* StateFlow
  - É um fluxo observável detentor de estado que emite as atualizações de estado novas e atuais para os coletores. No Android, StateFlow é uma ótima opção para classes que precisam manter um estado mutável observável.
  - Fonte: https://developer.android.com/kotlin/flow/stateflow-and-sharedflow?hl=pt-br
 
* Data Binding(ViewBinding)
  - É uma biblioteca de suporte que permite vincular componentes de interface nos seus layouts a fontes de dados no app usando um formato declarativo em vez de programaticamente.
  - Fonte:https://developer.android.com/topic/libraries/data-binding?hl=pt-br
 
 * Picasso 
  - É uma estrutura de gerenciamento de mídia e carregamento de imagens de código aberto rápida e eficiente para Android com uma  interface simples e fácil de usar.

 * Splash Screen
   - Utlizei a nova forma de se criar uma splash screen , mais rapida e simples , mas tambem utilizei outra forma em que adiciono um gif como tela inicial do app 

   * Shimmer Efeect loading
   - Utlizei a biblioteca para criacao do shimmer efeect , um estado de loading que aparece antes do conteudo estar pronto para ser exibido , tendo um visual que da um vislumbre de como a ui sera carregda .
