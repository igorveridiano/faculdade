/*global Phaser*/ /*global game*/
var controlMusic = true;
//Controle de pontos bonos
var controlBonos;
var endState = {
    //Cria tela de finalização do jogo
    create: function(){
        if (controlMusic){
            this.music = game.add.audio('music');
            this.music.loop = true;
            this.music.volume = 0.5;
            this.music.play();
            controlMusic = false;
        }
        
        //Verifica se o player alcançou a marca de salvar todos os aliados de cada faze faltando um segundo para a mesma acabar, caso tenha feito recebe um bonus na pontuação
        if (controlBonos == 3){
            game.global.score = game.global.score * 100000;
        }
        
        
        var txtEnd1 = game.add.text(game.world.centerX, 250, 'CONGRATULATIONS!!!!!!',{font:'40px emulogic',fill:'#fff'});
            txtEnd1.anchor.set(0.5);
        
        game.camera.follow(txtEnd1, Phaser.Camera.FOLLOW_LOCKON);
        
        var txtEnd2 = game.add.text(game.world.centerX, 350, 'THIS IS THE FINAL OF THE GAME THANK YOU FOR PLAYING',{font:'20px emulogic',fill:'#fff'});
            txtEnd2.anchor.set(0.5);
            
        var txtEnd3 = game.add.text(game.world.centerX, 450, 'YOUR SCORE IS ' + game.global.score,{font:'20px emulogic',fill:'#fff'});
            txtEnd3.anchor.set(0.5);
        
        var txtPressStart = game.add.text(game.world.centerX,650, 'PRESS ENTER TO RETURN FOR MENU',{font:'20px emulogic',fill:'#fff'});
            txtPressStart.anchor.set(0.5);
            
        game.add.tween(txtPressStart).to({y:550},1000).start();
        
        game.time.events.add(1000,function(){
            var enterKey = game.input.keyboard.addKey(Phaser.Keyboard.ENTER);
                enterKey.onDown.addOnce(this.startMenu,this);
        },this);
    },
    
    //Chama a tela de menu
    startMenu: function(){
        this.music.stop();
        
        if (game.global.score > game.global.highScore){
            game.global.highScore = game.global.score;
        }
        
        controlMusic = true;
        game.global.score = 0;
        game.global.life = 3;
        
        game.state.start('menu');
    }
};