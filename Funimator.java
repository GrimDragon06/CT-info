package uk.playdrop.cherrytree_idletextrpg;

import android.view.View;
import android.animation.Animator$AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.ViewGroup;
import android.animation.ObjectAnimator;
import java.util.HashMap;
import android.animation.AnimatorSet;
import android.animation.Animator;
import java.util.Map;

public class Funimator
{
    private Map<String, Animator[]> animatorPool;
    AnimatorSet set;
    
    public Funimator() {
        this.animatorPool = (Map<String, Animator[]>)new HashMap();
        this.CreateAnimationPool();
    }
    
    private void CreateAnimationPool() {
        this.animatorPool.put((Object)"Tada", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "scaleX", new float[] { 1.0f, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "scaleY", new float[] { 1.0f, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "rotation", new float[] { 0.0f, -3.0f, -3.0f, 3.0f, -3.0f, 3.0f, -3.0f, 3.0f, -3.0f, 0.0f }) });
        this.animatorPool.put((Object)"Pulse", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "scaleX", new float[] { 1.0f, 1.2f, 1.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "scaleY", new float[] { 1.0f, 1.2f, 1.0f }) });
        this.animatorPool.put((Object)"Flash", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "alpha", new float[] { 1.0f, 0.0f, 1.0f, 0.0f, 1.0f }) });
        this.animatorPool.put((Object)"SlideInDown", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "alpha", new float[] { 0.0f, 1.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "translationY", new float[] { 0.0f, 0.0f }) });
        this.animatorPool.put((Object)"SlideInUp", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "alpha", new float[] { 0.0f, 1.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "translationY", new float[] { 0.0f, 0.0f }) });
        this.animatorPool.put((Object)"SlideInLeft", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "alpha", new float[] { 0.0f, 1.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "translationX", new float[] { 0.0f, 0.0f }) });
        this.animatorPool.put((Object)"SlideInRight", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "alpha", new float[] { 0.0f, 1.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "translationX", new float[] { 0.0f, 0.0f }) });
        this.animatorPool.put((Object)"SlideOutDown", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "alpha", new float[] { 1.0f, 0.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "translationY", new float[] { 0.0f, 0.0f }) });
        this.animatorPool.put((Object)"SlideOutUp", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "alpha", new float[] { 1.0f, 0.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "translationY", new float[] { 0.0f, 0.0f }) });
        this.animatorPool.put((Object)"SlideOutLeft", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "alpha", new float[] { 1.0f, 0.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "translationX", new float[] { 0.0f, 0.0f }) });
        this.animatorPool.put((Object)"SlideOutRight", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "alpha", new float[] { 1.0f, 0.0f }), (Animator)ObjectAnimator.ofFloat((Object)null, "translationX", new float[] { 0.0f, 0.0f }) });
        this.animatorPool.put((Object)"FadeOut", (Object)new Animator[] { (Animator)ObjectAnimator.ofFloat((Object)null, "alpha", new float[] { 1.0f, 0.0f }) });
    }
    
    public void Start(final String s, final long duration, final AnimationData animationData) {
        (this.set = new AnimatorSet()).setDuration(duration);
        final Animator[] array = (Animator[])this.animatorPool.get((Object)s);
        if (array != null) {
            final int length = array.length;
            final Animator[] array2 = new Animator[length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = array[i].clone()).setTarget((Object)animationData.target);
            }
            s.hashCode();
            final int hashCode = s.hashCode();
            int n = -1;
            switch (hashCode) {
                case 1207170001: {
                    if (!s.equals((Object)"SlideInUp")) {
                        break;
                    }
                    n = 7;
                    break;
                }
                case 1037453606: {
                    if (!s.equals((Object)"SlideInRight")) {
                        break;
                    }
                    n = 6;
                    break;
                }
                case 448925629: {
                    if (!s.equals((Object)"SlideInLeft")) {
                        break;
                    }
                    n = 5;
                    break;
                }
                case 448697432: {
                    if (!s.equals((Object)"SlideInDown")) {
                        break;
                    }
                    n = 4;
                    break;
                }
                case -1226656904: {
                    if (!s.equals((Object)"SlideOutUp")) {
                        break;
                    }
                    n = 3;
                    break;
                }
                case -1756949473: {
                    if (!s.equals((Object)"SlideOutRight")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case -1996521052: {
                    if (!s.equals((Object)"SlideOutLeft")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -1996749249: {
                    if (!s.equals((Object)"SlideOutDown")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                case 7: {
                    animationData.target.setVisibility(0);
                    animationData.distance = ((ViewGroup)animationData.target.getParent()).getHeight() - animationData.target.getTop();
                    ((ObjectAnimator)array[0]).setFloatValues(new float[] { 0.0f, 1.0f });
                    ((ObjectAnimator)array[1]).setFloatValues(new float[] { (float)animationData.distance, 0.0f });
                    break;
                }
                case 6: {
                    animationData.target.setVisibility(0);
                    animationData.distance = ((ViewGroup)animationData.target.getParent()).getWidth() - animationData.target.getLeft();
                    ((ObjectAnimator)array[0]).setFloatValues(new float[] { 0.0f, 1.0f });
                    ((ObjectAnimator)array[1]).setFloatValues(new float[] { (float)animationData.distance, 0.0f });
                    break;
                }
                case 5: {
                    animationData.target.setVisibility(0);
                    animationData.distance = ((ViewGroup)animationData.target.getParent()).getWidth() - animationData.target.getLeft();
                    ((ObjectAnimator)array[0]).setFloatValues(new float[] { 0.0f, 1.0f });
                    ((ObjectAnimator)array[1]).setFloatValues(new float[] { (float)(-animationData.distance), 0.0f });
                    break;
                }
                case 4: {
                    animationData.target.setVisibility(0);
                    animationData.distance = animationData.target.getTop() + animationData.target.getHeight();
                    ((ObjectAnimator)array[0]).setFloatValues(new float[] { 0.0f, 1.0f });
                    ((ObjectAnimator)array[1]).setFloatValues(new float[] { (float)(-animationData.distance), 0.0f });
                    break;
                }
                case 3: {
                    ((ObjectAnimator)array[0]).setFloatValues(new float[] { 1.0f, 0.0f });
                    ((ObjectAnimator)array[1]).setFloatValues(new float[] { 0.0f, (float)(-animationData.target.getBottom()) });
                    break;
                }
                case 2: {
                    animationData.distance = ((ViewGroup)animationData.target.getParent()).getWidth() - animationData.target.getLeft();
                    ((ObjectAnimator)array[0]).setFloatValues(new float[] { 1.0f, 0.0f });
                    ((ObjectAnimator)array[1]).setFloatValues(new float[] { 0.0f, (float)animationData.distance });
                    break;
                }
                case 1: {
                    ((ObjectAnimator)array[0]).setFloatValues(new float[] { 1.0f, 0.0f });
                    ((ObjectAnimator)array[1]).setFloatValues(new float[] { 0.0f, (float)(-animationData.target.getRight()) });
                    break;
                }
                case 0: {
                    animationData.distance = ((ViewGroup)animationData.target.getParent()).getHeight() - animationData.target.getTop();
                    ((ObjectAnimator)array[0]).setFloatValues(new float[] { 1.0f, 0.0f });
                    ((ObjectAnimator)array[1]).setFloatValues(new float[] { 0.0f, (float)animationData.distance });
                    break;
                }
            }
            if (length == 1) {
                this.set.playTogether(new Animator[] { array2[0] });
            }
            else if (length == 2) {
                this.set.playTogether(new Animator[] { array2[0], array2[1] });
            }
            else if (length == 3) {
                this.set.playTogether(new Animator[] { array2[0], array2[1], array2[2] });
            }
        }
        else {
            Log.e("Funimator", "Unknown animation type: " + s);
        }
        this.set.start();
        this.set.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, animationData) {
            final Funimator this$0;
            final AnimationData val$data;
            
            public void onAnimationEnd(final Animator animator) {
                if (this.val$data.hideEnd) {
                    this.val$data.target.setVisibility(8);
                }
            }
        });
    }
    
    public static class AnimationData
    {
        public int distance;
        public int endAlpha;
        public boolean hideEnd;
        public int startAlpha;
        public View target;
        
        public AnimationData(final View target, final int distance, final boolean hideEnd, final int startAlpha, final int endAlpha) {
            this.target = target;
            this.distance = distance;
            this.hideEnd = hideEnd;
            this.startAlpha = startAlpha;
            this.endAlpha = endAlpha;
        }
    }
}
