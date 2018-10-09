# Android进阶之光学习Demo
### 2.2.6章节CoordinatorLayout实现ToolBar隐藏和折叠

        design:23.2.0’以上当把FloatActionBar的anchor写成CoordinatorLayout就会出现异常

        <android.support.design.widget.FloatingActionButton
                    android:id="@+id/fab"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="15dp"
                    android:src="@drawable/ic_launcher"
                    app:layout_anchor="@id/view_pager"
                    app:layout_anchorGravity="bottom|right"
                    app:layout_behavior="com.xgs.androiddemo.view.FooterBehavior"/>
### 2.2.6章节自定义Behavior

        @Override
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
            if (dy > 0 && directionChange < 0 || dy < 0 && directionChange > 0) {
                directionChange = 0;
                child.animate().cancel();
            }
            directionChange += dy;
            if (directionChange > child.getHeight() && child.getVisibility() == View.VISIBLE) {
                hide(child);
            } else if (directionChange < 0 && child.getVisibility() != View.VISIBLE) {
                show(child);
            }
        }

        private void hide(final View view) {
            ViewPropertyAnimator animator = view.animate().translationY(view.getHeight()).setInterpolator(new FastOutSlowInInterpolator()).setDuration(200);
            animator.setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(View.INVISIBLE);
                }
            });
            animator.start();
        }
不要用hide()方法，也不要使用setVisibility(GONE)，可以使用setVisibility(INVISIBLE)，25和24版本区别
