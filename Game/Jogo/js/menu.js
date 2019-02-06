/*global Phaser*/ /*global game*/ /*global localStorage*/ 
var menuState = {
    //Cria as caracteristicas do menu, incia e exibe elas
    create: function(){
        // Adiciona e inicia a musica na pagina
        this.music = game.add.audio('music');
        this.music.loop = true;
        this.music.volume = 0.5;
        this.music.play();
        
        //Verifica o Local Storage em busca de um highscore anterior
        if(!localStorage.getItem('saveYourAlly_highScore')){
            localStorage.setItem('saveYourAlly_highScore',0);
        }
        
        //Checa se o highscore da aplicação é maior que o do local storage
        if(game.global.highScore > localStorage.getItem('saveYourAlly_highScore')){
            //Caso seja salva o hihgscore da aplicação no local storage
            localStorage.setItem('saveYourAlly_highScore',game.global.highScore);
        } else {
            //Se não salva o local storage no highscore da aplicação
            game.global.highScore = localStorage.getItem('saveYourAlly_highScore');
        }
        
        //Cria e exibe o highscore na tela
        var txtHighScore = game.add.text(game.world.centerX,500,'HIGHSCORE: ' + game.global.highScore,{font:'20px emulogic',fill:'#D26111'});
            txtHighScore.anchor.set(0.5);
            txtHighScore.alpha = 0; 
        
        //Cria e exibe o nome do jogo
        var txtSaveyourAlly = game.add.text(game.world.centerX, 200, 'SAVE YOUR ALLY',{font:'40px emulogic',fill:'#fff'});
            txtSaveyourAlly.anchor.set(0.5);
            
            //Faz com que a camera siga o texto do nome do jogo
            game.camera.follow(txtSaveyourAlly, Phaser.Camera.FOLLOW_LOCKON);
        
        //Cira e exibe o  texto Press Enter para iniciar
        var txtPressStart = game.add.text(game.world.centerX,650, 'PRESS ENTER TO START THE GAME',{font:'20px emulogic',fill:'#fff'});
            txtPressStart.anchor.set(0.5);
    
        //Adiciona um evento para o pressStart    
        game.add.tween(txtPressStart).to({y:300},1000).start();
        
        //Cira e exibe o  texto Press T para iniciar o tutorial
        var txtPressTutorial = game.add.text(game.world.centerX,750, 'PRESS T FOR TUTORIAL',{font:'20px emulogic',fill:'#fff'});
            txtPressTutorial.anchor.set(0.5);
        
        //Adiciona um evento para o pressTutorial     
        game.add.tween(txtPressTutorial).to({y:400},1000).start();
        
        //Cria um evento de tempo para o evento pressStart
        game.time.events.add(1000,function(){
            game.add.tween(txtHighScore).to({alpha:1},600).to({alpha:0},600).loop().start();

            //Verifica se a tecla enter foi presssionada
            var enterKey1 = game.input.keyboard.addKey(Phaser.Keyboard.ENTER);
                //Se tiver ele starta o metodo startGame
                enterKey1.onDown.addOnce(this.startGame,this);
            var enterKey2 = game.input.keyboard.addKey(Phaser.Keyboard.T);
                //Se tiver ele starta o metodo startGame
                enterKey2.onDown.addOnce(this.startTutorial,this);    
        },this);
        
        
    },
    
    //Inicia a fase 1 do jogo
    startGame: function(){
        //Para a musica
        this.music.stop();
        //inicia a pagina stage1
        game.state.start('stage1');
    },
    
    //Inicia o tutorial do jogo
    startTutorial: function(){
        //Para a musica
        this.music.stop();
        //inicia a pagina stage1
        game.state.start('tutorial');
    },
};