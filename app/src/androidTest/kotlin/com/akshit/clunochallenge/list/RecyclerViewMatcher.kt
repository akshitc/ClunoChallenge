package com.akshit.clunochallenge.list

import android.content.res.Resources
import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

class RecyclerViewMatcher(val recyclerViewId: Int) {

    fun atPosition(position: Int): Matcher<View> {
        return atPositionOnView(position, -1)
    }

    fun atPositionOnView(position: Int, @IdRes targetViewId: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            var resources: Resources? = null
            var childView: View? = null

            override fun describeTo(description: Description) {
                var idDescription = Integer.toString(recyclerViewId)
                if (this.resources != null) {
                    try {
                        idDescription = this.resources!!.getResourceName(recyclerViewId)
                    } catch (var4: Resources.NotFoundException) {
                        idDescription = String.format("%s (resource name not found)", recyclerViewId)
                    }

                }

                description.appendText("RecyclerView with id: $idDescription at position: $position")
            }

            override fun matchesSafely(view: View): Boolean {
                this.resources = view.getResources()

                if (childView == null) {
                    val recyclerView = view.rootView.findViewById(recyclerViewId) as? RecyclerView
                    if (recyclerView != null && recyclerView.id == recyclerViewId) {
                        val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
                        if (viewHolder != null) {
                            childView = viewHolder.itemView
                        }
                    } else {
                        return false
                    }
                }

                if (targetViewId == -1) {
                    return view === childView
                } else {
                    val targetView = childView?.findViewById<View>(targetViewId)
                    return view === targetView
                }
            }
        }
    }
}
