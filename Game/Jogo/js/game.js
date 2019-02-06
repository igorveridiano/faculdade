/*global Phaser*/ /*global bootState*/ /*global loadState*/ /*global menuState*/ /*global stage1State*/ /*global stage2State*/ /*global stage3State*/
/*global endState*/ /*global gameOverState*/ /*global tutorialState*/
//Cria o jogo e sua tela com os valores de tamanhos que são passados a seguir
var game = new Phaser.Game(1350,600,Phaser.AUTO);

      game.global = {
            score: 0,
            highScore: 0,
            life: 3
      };
      
      //Defini as classses que o jogo ira reconhecer
      game.state.add('boot',bootState);
      game.state.add('load',loadState);
      game.state.add('menu', menuState);
      game.state.add('tutorial',tutorialState);
      game.state.add('stage1',stage1State);
      game.state.add('stage2',stage2State);
      game.state.add('stage3',stage3State);
      game.state.add('gameOver',gameOverState);
      game.state.add('end',endState);
      
      game.state.start('boot'); 