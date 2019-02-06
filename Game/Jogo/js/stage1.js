/*global Phaser*/ /*global game*/
//Textos da vida e dos pontos a serem exibidos na tela
var txtScore;
var txtlife;
//Temporizador
var txtTimer;
var time = 50;
var timer;
//Controlador da musica
var controlMusic = true;
//Variaveis de controle dos aliados salvos
var controlAlly1 = true;
var controlAlly2 = true;
var controlAlly3 = true;
//Controle para a passagem de fase
var controlPhase = 0;
//Controle de pontos bonos
var controlBonos;
var stage1State = {
    //Cria os elementos do jogo da fase 1
    create: function(){
        this.onGame = true;
        
        //Adiciona e inica a musica do jogo
        if (controlMusic){
            this.music = game.add.audio('music');
            this.music.loop = true;
            this.music.volume = 0.5;
            this.music.play();
            controlMusic = false;
        }
        
        //Adiciona e pega as teclas que serão utilizadas no jogo
        this.keys = game.input.keyboard.createCursorKeys();
        this.aButton = game.input.keyboard.addKey(Phaser.Keyboard.A);
        this.dButton = game.input.keyboard.addKey(Phaser.Keyboard.D);
        this.wButton = game.input.keyboard.addKey(Phaser.Keyboard.W);
        
        //Adiciona uma imagem de fudo para o jogo
        game.add.sprite(0, 0,'background1');
        //Seta o tamanho do mundo do jogo
        game.world.setBounds(0, 0, 1920, 1200);
    
        this.createPlatforms();
        this.createPlayer();
        this.createEnemys();
        this.createAlly();
        this.createTrap();
        

        //Variavel de controle da movimentação do inimigo
        this.controlEnemy = -1;
        
        //Cria o texto que mostra as vidas do player na tela
        txtlife = game.add.text(0,30,'LIFES: ' + game.global.life,{font:'22px emulogic', fill:'#fff'});
        //Fixa o texto das vidas na camera para quando o personagem se mover o texto ir junto
        txtlife.fixedToCamera = true;
        
        //Cria o texto que mostra o score do player na tela
        txtScore = game.add.text(0,0,'SCORE: ' + game.global.score,{font:'22px emulogic', fill:'#fff'});
        //Fixa o texto do score na camera para quando o personagem se mover o texto ir junto
        txtScore.fixedToCamera = true;
        
        //Timer
        txtTimer = game.add.text(1350 - 300, 0,'TIME: ' + time,{font:'22px emulogic', fill:'#fff'});
        txtTimer.fixedToCamera = true;
        timer = game.time.events.loop(1000, function(){
            time--;
            txtTimer.text = 'Time: ' + time;
        },this);
        
        game.time.events.add(180000,function(){
            var enterKey = game.input.keyboard.addKey(Phaser.Keyboard.ENTER);
                enterKey.onDown.addOnce(this.startNextStage,this);
        },this);
    },

    //Da o update dos eventos que ocorrem na fase
    update: function(){
        if (this.onGame){
            //Faz a fisica de colisão do player com a plataforma
            game.physics.arcade.collide(this.player,this.platforms);
            //Faz a fisica de colisão do enimigo com a plataforma
            game.physics.arcade.collide(this.enemy1,this.platforms);
            game.physics.arcade.collide(this.enemy2,this.platforms);
            game.physics.arcade.collide(this.enemy3,this.platforms);
            game.physics.arcade.collide(this.enemy4,this.platforms);
            game.physics.arcade.collide(this.enemy5,this.platforms);
            game.physics.arcade.collide(this.enemy6,this.platforms);
            game.physics.arcade.collide(this.enemy7,this.platforms);
            //Faz a fisicia de colisão do aliado com a plataforma 
            game.physics.arcade.collide(this.ally1,this.platforms);
            game.physics.arcade.collide(this.ally2,this.platforms);
            game.physics.arcade.collide(this.ally3,this.platforms);
            //Faz a fisicia de colisão da armadilha com a plataforma 
            game.physics.arcade.collide(this.traps,this.platforms);
            //Faz a fisica da colisão do inimigo com player e ativa o evento de morte do player
            game.physics.arcade.collide(this.enemy1,this.player,this.deathPlayer); 
            game.physics.arcade.collide(this.enemy2,this.player,this.deathPlayer);
            game.physics.arcade.collide(this.enemy3,this.player,this.deathPlayer);
            game.physics.arcade.collide(this.enemy4,this.player,this.deathPlayer);
            game.physics.arcade.collide(this.enemy5,this.player,this.deathPlayer);
            game.physics.arcade.collide(this.enemy6,this.player,this.deathPlayer);
            game.physics.arcade.collide(this.enemy7,this.player,this.deathPlayer);
            //Faz a fisica da colisão das armadilhas com player e ativa o evento de morte do player
            game.physics.arcade.collide(this.traps,this.player,this.deathPlayer); 
            //Faz a fisica de colisão do player com o aliado e verifica se o player o salvou
            game.physics.arcade.collide(this.player,this.ally1,this.saveAlly);
            game.physics.arcade.collide(this.player,this.ally2,this.saveAlly);
            game.physics.arcade.collide(this.player,this.ally3,this.saveAlly);
            
            this.movePlayer();
            this.moveEnemyType1(this.enemy1);
            this.moveEnemyType1(this.enemy2);
            this.moveEnemyType1(this.enemy3);
            this.moveEnemyType1(this.enemy4);
            this.moveEnemyType2(this.enemy5);
            this.moveEnemyType2(this.enemy6);
            this.moveEnemyType2(this.enemy7);
            
            if (time < 1 || game.global.life < 0){
                this.startGameOver();
            }
            
            if (controlPhase == 3){
                this.startNextStage();
            }
        }
    },
    
    //Faz a movimentação do player
    movePlayer: function(){
        //Defini a velocida inical do player no eixo x como zero
        this.player.body.velocity.x = 0;
        
        //Se a tecla para andar para esquerda etiver pressionada anda para esquerda 
        if (this.keys.left.isDown || this.aButton.isDown){
              this.player.body.velocity.x = -200;
              this.player.animations.play('left');
        //Se for a tecla para direita anda para a direita      
          }else if (this.keys.right.isDown || this.dButton.isDown){
              this.player.body.velocity.x = 200;
              this.player.animations.play('right');
        //Se não for nenhuma das duas fica parado      
          }else {
              this.player.animations.stop();
              this.player.frame = 4;
          }
          //Se a tecla para pular for pressionada ele pula
          if ((this.keys.up.isDown || this.wButton.isDown) && this.player.body.touching.down){
              this.player.body.velocity.y = -260;
          }
    },
    
    //Controle do movimento do inimigo
    moveEnemyType1: function(enemy){
        //Defini a velocidade incial do inimigo no eixo x quando inicia o jogo como 0
        enemy.body.velocity.x = 0;
        
        //Verifica se o controlador do movimento do inimigo é maior que 0, se for o inimigo anda para direita e o controlador recebe mais um 
        if (this.controlEnemy > 0){
              this.controlEnemy++;
              enemy.body.velocity.x = 200;
              enemy.animations.play('right');
              //Quando o controlador chega a mais que 190 o controlador, o cotrolador é setado para -1
              if(this.controlEnemy > 1000) {
                  this.controlEnemy = -1;
              }
        //Se o controlador for menor que zero o inimigo anda para a esquerda e o controlador recebe menos um      
        } else if (this.controlEnemy < 0){
              this.controlEnemy--;
              enemy.body.velocity.x = -200;
              enemy.animations.play('left');
              //Quando o controlador chega a menos que -190 o controlador, o cotrolador é setado para 1
              if (this.controlEnemy < -1000){
                  this.controlEnemy = 1;
              }
        }
    },
    
    moveEnemyType2: function(enemy){
        //Defini a velocidade incial do inimigo no eixo x quando inicia o jogo como 0
        enemy.body.velocity.x = 0;
        
        //Verifica se o controlador do movimento do inimigo é maior que 0, se for o inimigo anda para direita e o controlador recebe mais um 
        if (this.controlEnemy < 0){
              this.controlEnemy--;
              enemy.body.velocity.x = 150;
              enemy.animations.play('right');
              //Quando o controlador chega a mais que 190 o controlador, o cotrolador é setado para -1
              if(this.controlEnemy < -1000) {
                  this.controlEnemy = 1;
              }
        //Se o controlador for menor que zero o inimigo anda para a esquerda e o controlador recebe menos um      
        } else if (this.controlEnemy > 0){
              this.controlEnemy++;
              enemy.body.velocity.x = -150;
              enemy.animations.play('left');
              //Quando o controlador chega a menos que -190 o controlador, o cotrolador é setado para 1
              if (this.controlEnemy > 1000){
                  this.controlEnemy = -1;
              }
        }
    },
    
    //Função que faz o evento da morte do player
    deathPlayer: function(enemy, player){
        player.kill();
        //Diminui a vida do player
        game.global.life--;
        //Diminui o tempo como uma penalidade pelo player ter morrido
        time = time - 10;
        txtTimer.text = 'TIME: ' + time;
        //Reinicia a faze
        game.state.start('stage1');
    },
    
    
    //Função que cria o player
    createPlayer: function(){
        //Adiciona a imagem do personagem
        this.player = game.add.sprite(0,145,'dude');
    
        //Inicia a fisica do player
        game.physics.arcade.enable(this.player);
    
        //Defini as fisicas que se aplicam ao player
        this.player.body.gravity.y = 300;
        this.player.body.bounce.y = 0.15;
        this.player.body.collideWorldBounds = true;
        this.player.animations.add('left',[0,1,2,3],10,true);
        this.player.animations.add('right',[5,6,7,8],10,true);
        
        game.camera.follow(this.player, Phaser.Camera.FOLLOW_LOCKON);
    },
    
    //Função de salvamento do aliado
    saveAlly: function(player, ally){
        //Vai fazer com que o aliado desapareça da tela
        ally.kill();
        //Se a vida do player for maior que 0 os pontos ganhos por salvar um aliado é mutiplicado pelo numero de vidas que o player tiver
        //Se a vida do player for igual a 0 o player so ganha os pontos de ter salvo o aliado
        if (game.global.life > 0){
            game.global.score += 300 * game.global.life;
        } else if (game.global.life == 0) {
            game.global.score += 300;
        }
        txtScore.text = 'SCORE: ' + game.global.score;
        if (game.global.score > game.global.highScore){
            game.global.highScore = game.global.score;
        }
        //Aumenta o controle para passar de faze em mais 1
        controlPhase++;
        //Ao salvar o aliado o player ganha uma vida extra
        game.global.life++;
        txtlife.text = 'LIFES: ' + game.global.life;
        if (ally.position.x == 0){
            controlAlly1 = false;
        } else if (ally.position.x == 1821){
            controlAlly2 = false;
        } else if(ally.position.x == 1097) {
            controlAlly3 = false;
        }
        //Ganha 10 segundos a mais no tempo por salvar o aliado
        time = time + 10;
        txtTimer.text = 'TIME: ' + time;
    },
    
    //Função que cria as plataformas por onde o player ira andar
    createPlatforms: function(){
        //Cria um grupo de plataformas
        this.platforms = game.add.group();
        this.platforms.enableBody = true;
        
        //Cria uma plataforma passando aonde ela sera criada
        var platform = this.platforms.create(0,190,'platform');
            //Modifica a scala da imagem da plataforma
            platform.scale.setTo(2,0.3);
            //Torna a plataforma imovivel
            platform.body.immovable = true;
    
        platform = this.platforms.create(700, 300,'platform');
        platform.scale.setTo(2,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(700, 720,'platform');
        platform.scale.setTo(2,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(900, 610,'platform');
        platform.scale.setTo(1,0.3);
        platform.body.immovable = true
    
        platform = this.platforms.create(650, 590,'platform');
        platform.scale.setTo(0.5,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(600, 410,'platform');
        platform.scale.setTo(0.25,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(200, 500,'platform');
        platform.scale.setTo(1,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(0, 1150,'platform');
        platform.scale.setTo(7,0.4);
        platform.body.immovable = true;
    
        platform = this.platforms.create(80, 930,'platform');
        platform.scale.setTo(1,0.3);
        platform.body.immovable = true
    
        platform = this.platforms.create(300, 820,'platform');
        platform.scale.setTo(2,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(200, 1040,'platform');
        platform.scale.setTo(2,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(1400, 1040,'platform');
        platform.scale.setTo(1.5,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(1000, 930,'platform');
        platform.scale.setTo(1,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(1500, 830,'platform');
        platform.scale.setTo(1,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(1400, 500,'platform');
        platform.scale.setTo(1,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(1700, 390,'platform');
        platform.scale.setTo(0.6,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(1700, 610,'platform');
        platform.scale.setTo(0.6,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(0, 610,'platform');
        platform.scale.setTo(0.6,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(150, 710,'platform');
        platform.scale.setTo(0.6,0.3);
        platform.body.immovable = true;
    
        platform = this.platforms.create(50, 390,'platform');
        platform.scale.setTo(0.6,0.3);
        platform.body.immovable = true;
    },
    
    //Função que cria os inimigos
    createEnemys: function(){
        //Adiciona a imagem do inimigo
        this.enemy1 = game.add.sprite(1200,220,'orc');
        
        //Inicia a fisica do inimigo
        game.physics.arcade.enable(this.enemy1);
        
        //Defini as fisicas que se aplicam ao inimigo
        this.enemy1.body.gravity.y = 300;
        this.enemy1.body.bounce.y = 0.15;
        this.enemy1.body.collideWorldBounds = true;
        this.enemy1.animations.add('left',[9,10,11,12,13,14,15,16,17],10,true);
        this.enemy1.animations.add('right',[27,28,29,30,31,32,33,34,35],10,true);
        
        this.enemy2 = game.add.sprite(556,130,'orc');

        game.physics.arcade.enable(this.enemy2);
        
        this.enemy2.body.gravity.y = 300;
        this.enemy2.body.bounce.y = 0.15;
        this.enemy2.body.collideWorldBounds = true;
        this.enemy2.animations.add('left',[9,10,11,12,13,14,15,16,17],10,true);
        this.enemy2.animations.add('right',[27,28,29,30,31,32,33,34,35],10,true);
        
        this.enemy3 = game.add.sprite(1168,660,'orc');

        game.physics.arcade.enable(this.enemy3);
        
        this.enemy3.body.gravity.y = 300;
        this.enemy3.body.bounce.y = 0.15;
        this.enemy3.body.collideWorldBounds = true;
        this.enemy3.animations.add('left',[9,10,11,12,13,14,15,16,17],10,true);
        this.enemy3.animations.add('right',[27,28,29,30,31,32,33,34,35],10,true);
        
        this.enemy4 = game.add.sprite(1000,760,'orc');

        game.physics.arcade.enable(this.enemy4);
        
        this.enemy4.body.gravity.y = 300;
        this.enemy4.body.bounce.y = 0.15;
        this.enemy4.body.collideWorldBounds = true;
        this.enemy4.animations.add('left',[9,10,11,12,13,14,15,16,17],10,true);
        this.enemy4.animations.add('right',[27,28,29,30,31,32,33,34,35],10,true);
        
        this.enemy5 = game.add.sprite(210,980,'enemy');

        game.physics.arcade.enable(this.enemy5);
        
        this.enemy5.body.gravity.y = 300;
        this.enemy5.body.bounce.y = 0.15;
        this.enemy5.body.collideWorldBounds = true;
        this.enemy5.animations.add('left',[9,10,11,12,13,14,15,16,17],10,true);
        this.enemy5.animations.add('right',[27,28,29,30,31,32,33,34,35],10,true);
        
        this.enemy6 = game.add.sprite(300,760,'enemy');

        game.physics.arcade.enable(this.enemy6);
        
        this.enemy6.body.gravity.y = 300;
        this.enemy6.body.bounce.y = 0.15;
        this.enemy6.body.collideWorldBounds = true;
        this.enemy6.animations.add('left',[9,10,11,12,13,14,15,16,17],10,true);
        this.enemy6.animations.add('right',[27,28,29,30,31,32,33,34,35],10,true);
        
        this.enemy7 = game.add.sprite(1795,979,'enemy');

        game.physics.arcade.enable(this.enemy7);
        
        this.enemy7.body.gravity.y = 300;
        this.enemy7.body.bounce.y = 0.15;
        this.enemy7.body.collideWorldBounds = true;
        this.enemy7.animations.add('left',[9,10,11,12,13,14,15,16,17],10,true);
        this.enemy7.animations.add('right',[27,28,29,30,31,32,33,34,35],10,true);
    },
    
    //Função que cria os aliados
    createAlly: function(){
        if (controlAlly1){
            //Adiciona a imagem do aliado
            this.ally1 = game.add.sprite(0,580,'ally');
        
            //Inicia a fisica do aliado
            game.physics.arcade.enable(this.ally1);
        
            //Defini as fisicas que se aplicam ao aliado
            this.ally1.body.gravity.y = 300;
            this.ally1.body.bounce.y = 0.15;
            this.ally1.body.collideWorldBounds = true;
            this.ally1.frame = 1;
        } 
        
        if (controlAlly2){
            this.ally2 = game.add.sprite(1821,552,'ally');
        
            game.physics.arcade.enable(this.ally2);
        
            this.ally2.body.gravity.y = 300;
            this.ally2.body.bounce.y = 0.15;
            this.ally2.body.collideWorldBounds = true;
            this.ally2.frame = 7;
        }
        
        if(controlAlly3){
            this.ally3 = game.add.sprite(1097,552,'ally');
        
            game.physics.arcade.enable(this.ally3);
        
            this.ally3.body.gravity.y = 300;
            this.ally3.body.bounce.y = 0.15;
            this.ally3.body.collideWorldBounds = true;
            this.ally3.frame = 49;
        }
    },
    
    //Função que cria os aliados
    createTrap: function(){
        //Cria um grupo de armadilhas
        this.traps = game.add.group();
        this.traps.enableBody = true;
        
        //Cria uma armadilha passando aonde ela sera criada
        var trap = this.traps.create(630,358,'trap');
            //Modifica a scala da imagem da armadilha
            trap.scale.setTo(1,1);
            //Torna a armadilha imovivel
            trap.body.immovable = true;
            
        trap = this.traps.create(35,554,'trap');
        trap.scale.setTo(1,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(2,1090,'trap');
        trap.scale.setTo(2,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(1829,1090,'trap');
        trap.scale.setTo(2,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(1130,872,'trap');
        trap.scale.setTo(2,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(1652,772,'trap');
        trap.scale.setTo(2,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(1715,552,'trap');
        trap.scale.setTo(1,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(270,652,'trap');
        trap.scale.setTo(1,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(140,332,'trap');
        trap.scale.setTo(1,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(354,442,'trap');
        trap.scale.setTo(1,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(694,532,'trap');
        trap.scale.setTo(1,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(970,552,'trap');
        trap.scale.setTo(2,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(480,980,'trap');
        trap.scale.setTo(2,1);
        trap.body.immovable = true;
        
        trap = this.traps.create(166,870,'trap');
        trap.scale.setTo(1,1);
        trap.body.immovable = true;

        trap = this.traps.create(1512,440,'trap');
        trap.scale.setTo(1,1);
        trap.body.immovable = true
        
        trap = this.traps.create(1816,330,'trap');
        trap.scale.setTo(1,1);
        trap.body.immovable = true;
    },
    
    //Chama a proxima tela do jogo
    startNextStage: function(){
        this.music.stop();
        
        if (time == 1){
            controlBonos += 1;
        }
        
        game.global.score += game.global.score * time;
        
        time = time + (6 * 10);
        
        controlAlly1 = true;
        controlAlly2 = true;
        controlAlly3 = true;
        controlMusic = true;
        controlPhase = 0
        
        game.state.start('stage2');
    },
    
    //Chama a tela de game over
    startGameOver: function(){
        this.onGame = false;
        
        this.music.stop();
        
        controlAlly1 = true;
        controlAlly2 = true;
        controlAlly3 = true;
        controlMusic = true;
        controlPhase = 0;
        
        game.state.start('gameOver');
    },

};