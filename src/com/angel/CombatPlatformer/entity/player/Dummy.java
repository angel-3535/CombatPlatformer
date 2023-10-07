package com.angel.CombatPlatformer.entity.player;

import com.angel.CombatPlatformer.component.Animator;
import com.angel.CombatPlatformer.component.Transform;
import com.angel.CombatPlatformer.entity.Enemy.Enemy_Constants;
import com.angel.CombatPlatformer.util.Vector2D;
import com.angel.CombatPlatformer.window.WindowConstants;

import java.awt.*;

public class Dummy {

    //Player TransformRef
    Transform playerTransform = null;

    //Transform
    Transform transform = null;

    //animation variables
    private boolean facingLeft = false;
    private final Animator animator;

    //movement variables
    private double y_Velocity = 0.0;
    private Vector2D movementVector = new Vector2D();


    public Dummy(Transform playerTransform){
        this.playerTransform = playerTransform;

         Vector2D position = new Vector2D(WindowConstants.SCREEN_WIDTH / 2, WindowConstants.SCREEN_HEIGHT-Enemy_Constants.DUMMY_HEIGHT);
         Vector2D rotation = new Vector2D();
         Vector2D size = new Vector2D(Enemy_Constants.DUMMY_WIDTH,Enemy_Constants.DUMMY_HEIGHT);

        transform = new Transform(position,rotation,size);


        animator = new Animator(0.075);

        animator.addAnimation(Enemy_Constants.DUMMY_IDLE_ANIMATION, Enemy_Constants.DUMMY_IDLE_ANIMATION_ID);

    }


    public void init() {

    }


    public void update(double deltaTime) {
        animator.update(deltaTime);
        facingLeft = playerTransform.position.x < transform.position.x;

    }

    public void draw(Graphics g) {

        if(animator.hasAnimations()){
            if (!facingLeft){
                animator.RenderCurrentSprite(g, (int) transform.position.x, (int) transform.position.y);
            }else{
                animator.RenderCurrentSpriteFlipVer(g, (int) transform.position.x, (int) transform.position.y);
            }
        }

        g.setColor(Color.RED);
        g.drawRect(
                (int) transform.position.x,
                (int) transform.position.y,
                (int) transform.size.x,
                (int) transform.size.y);
    }
}
