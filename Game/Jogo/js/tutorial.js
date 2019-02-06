/*global Phaser*/ /*global game*/ 
var tutorialState = {
    //Cria as caracteristicas do menu, incia e exibe elas
    create: function(){
        // Adiciona e inicia a musica na pagina
        this.music = game.add.audio('music');
        this.music.loop = true;
        this.music.volume = 0.5;
        this.music.play();
        
        //Cria e exibe o nome do jogo
        var txtSaveyourAlly = game.add.text(game.world.centerX, 70, 'TUTORIAL',{font:'40px emulogic',fill:'#fff'});
            txtSaveyourAlly.anchor.set(0.5);
            
            //Faz com que a camera siga o texto do nome do jogo
            game.camera.follow(txtSaveyourAlly, Phaser.Camera.FOLLOW_LOCKON);
        
        //Cira e exibe o  texto Press Enter para retorno ao menu
        var txtPressStart = game.add.text(game.world.centerX,950, 'PRESS ENTER TO RETURN FOR THE MENU',{font:'30px emulogic',fill:'#fff'});
            txtPressStart.anchor.set(0.5);
            
        //Adiciona um evento para o pressStart    
        game.add.tween(txtPressStart).to({y:550},1000).start();
        
        //Cira e exibe o  texto do sobre o jogo
        var txtAbout = game.add.text(game.world.centerX,600, '-THE GOAL OF THE GAME IS SAVE YOUR ALLIES WITHOUT TOUCHING THE' + 
        ' TRAPPINGS OR ENEMIES IN THE FASTEST TIME YOU CAN DO.',{font:'10px emulogic',fill:'#fff'});
            txtAbout.anchor.set(0.5);
            
        //Adiciona um evento para o pressAlly  
        game.add.tween(txtAbout).to({y:150},1000).start();
        
        //Cira e exibe o  texto do sobre a pontuação do jogo
        var txtScore = game.add.text(game.world.centerX,650, '-THE SCORE IN THE GAME IS BASED IN THE LIFES YOU HAVE BEFORE SAVE ONE ALLY MULTIPLIED BY 300' +
        '\n' + 'AND IN THE FINAL OF THE PHASE YOUR SCORE IS MULTIPLIED BY THE REMAINING TIME TO FINISH THE PHASE.',{font:'10px emulogic',fill:'#fff'});
            txtScore.anchor.set(0.5);
            
        //Adiciona um evento para o pressAlly  
        game.add.tween(txtScore).to({y:200},1000).start();
        
        //Cira e exibe o  texto do sobre o que acontece se voce tocar uma armadiha ou enimigo no jogo
        var txtEnemy = game.add.text(game.world.centerX,700, '-IN THE GAME IF YOU TOUCH A ENEMY OR TRAP YOU DIE AND LESS 10 SECONDS' + 
        ' IN THE TIME TO FINISH THE PHASE.',{font:'10px emulogic',fill:'#fff'});
            txtEnemy.anchor.set(0.5);
            
        //Adiciona um evento para o pressAlly  
        game.add.tween(txtEnemy).to({y:250},1000).start();
        
        //Cira e exibe o  texto do sobre como salvar os aliados no jogo
        var txtAlly = game.add.text(game.world.centerX,750, '-IN THE GAME TO SAVE YOUR ALLIES YOU JUST NEED TO TOUCH THE, WHEN YOU SAVE A ' + 
        'ALLY YOU GAIN 1 MORE LIFE' + '\n' + 'AND 10 SECONDS MORE FOR THE TIME TO FINISH THE PHASE.',{font:'10px emulogic',fill:'#fff'});
            txtAlly.anchor.set(0.5);
            
        //Adiciona um evento para o pressAlly  
        game.add.tween(txtAlly).to({y:305},1000).start();
        
        //Cira e exibe o  texto do direcional do player do jogo
        var txtDirecionalW = game.add.text(game.world.centerX,800, '-IN THE GAME PRESS W OR UP ARROW FOR JUMP.',{font:'10px emulogic',fill:'#fff'});
            txtDirecionalW.anchor.set(0.5);
            
        //Adiciona um evento para o pressDirecionalW   
        game.add.tween(txtDirecionalW).to({y:355},1000).start();
        
        //Cira e exibe o  texto do direcional do player do jogo
        var txtDirecionalA = game.add.text(game.world.centerX,850, '-IN THE GAME PRESS A OR LEFT ARROW FOR RUN TO LEFT.',{font:'10px emulogic',fill:'#fff'});
            txtDirecionalA.anchor.set(0.5);
            
        //Adiciona um evento para o pressDirecionalA   
        game.add.tween(txtDirecionalA).to({y:405},1000).start();
        
        //Cira e exibe o  texto do direcional do player do jogo
        var txtDirecionalD = game.add.text(game.world.centerX,900, '-IN THE GAME PRESS D OR RIGHT ARROW FOR RUN TO RIGHT.',{font:'10px emulogic',fill:'#fff'});
            txtDirecionalD.anchor.set(0.5);
            
        //Adiciona um evento para o pressDirecionalA   
        game.add.tween(txtDirecionalD).to({y:455},1000).start();
        
        //Cria um evento de tempo para o evento pressStart
        game.time.events.add(1000,function(){
            //Verifica se a tecla enter foi presssionada
            var enterKey = game.input.keyboard.addKey(Phaser.Keyboard.ENTER);
                //Se tiver ele starta o metodo startGame
                enterKey.onDown.addOnce(this.returnMenu,this);
        },this);
    },
    
    //Inicia a fase 1 do jogo
    returnMenu: function(){
        //Para a musica
        this.music.stop();
        //inicia a pagina stage1
        game.state.start('menu');
    }
};