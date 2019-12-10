package com.ebookfrenzy.tablayoutdemo

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.support.design.widget.TabLayout
import android.view.View
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_tab_layout_demo.*
import kotlinx.android.synthetic.main.contactme.*
import android.os.Build
import android.transition.Slide
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlinx.android.synthetic.main.add_skill.*
import kotlinx.android.synthetic.main.add_skill.view.*
import kotlinx.android.synthetic.main.skills_popup.view.*


class TabLayoutDemoActivity : AppCompatActivity() {

    var skillsPopupWindow: PopupWindow? = null
    var addSkillPopupWindow: PopupWindow? = null
    lateinit var view: View
    var skills:ArrayList<String> = arrayListOf("java", "android", "php", "c#")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout_demo)
        setSupportActionBar(toolbar)

        configureTabLayout()

        skillsPopupWindow = skillsPopupInit(R.layout.skills_popup,skillsPopupWindow)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, skills)
        view.listView.adapter = adapter

        addSkillPopupWindow = skillsPopupInit(R.layout.add_skill,addSkillPopupWindow)

        //floating button
        val mFab = findViewById<FloatingActionButton>(R.id.fab)
        mFab.setOnClickListener {
            addSkillPopupWindow?.showAtLocation(
                    toolbar, // Location to display popup window
                    Gravity.TOP, // Exact position of layout to display popup
                    0, // X offset
                    0 // Y offset
            )
        }


    }

    fun openGithub(view: View) {
        // To open links clicked by the user in the WebView instead of Default Browser
        web_view.webViewClient = WebViewClient()
        web_view.loadUrl(getString(R.string.github).toString())
    }

    fun skillsPopupInit(xmlId : Int, popupWindow: PopupWindow?): PopupWindow{
        view = layoutInflater.inflate(xmlId, null)
        var popup = popupWindow
        popup = PopupWindow(
                view, // Custom view to show in popup window
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                LinearLayout.LayoutParams.WRAP_CONTENT // Window height
        )

        popup.setOnDismissListener {
            popup.dismiss()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popup.elevation = 10.0F
        }


        // If API level 23 or higher then execute the code
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Create a new slide animation for popup window enter transition
            val slideIn = Slide()
            slideIn.slideEdge = Gravity.TOP
            popup.enterTransition = slideIn

            // Slide animation for popup window exit transition
            val slideOut = Slide()
            slideOut.slideEdge = Gravity.RIGHT
            popup.exitTransition = slideOut

        }

        popup.setFocusable(true)
        popup.update()

        return popup
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        skillsPopupWindow?.showAtLocation(
                toolbar, // Location to display popup window
                Gravity.CENTER, // Exact position of layout to display popup
                0, // X offset
                0 // Y offset
        )

        return super.onOptionsItemSelected(item)
    }


    fun btnAddSkills(v: View){
        if (view.skill.text.toString() != null && view.skill.text.toString().isNotBlank()) {
            skills.add(view.skill.text.toString())
        }
        addSkillPopupWindow?.dismiss()
        view.skill.text = null
    }
    fun btnDismissSkills(v: View) {
        skillsPopupWindow?.dismiss()
    }
    fun View.hideKeyboard(inputMethodManager: InputMethodManager) {
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }

    private fun configureTabLayout() {
        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.ic_dialog_info))
        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.ic_menu_info_details))
        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.stat_sys_phone_call))

        val adapter = TabPagerAdapter(supportFragmentManager, tab_layout.tabCount)
        // pager is the ViewPager id from the layout file
        pager.adapter = adapter

        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        /*Finally, the onTabSelectedListener is configured on the TabLayout instance
         and the onTabSelected() method implemented to set the current page on the ViewPager
          based on the currently selected tab number.*/

        tab_layout.run {
            // pager is the ViewPager id from the layout file
            pager.adapter = adapter
            pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

            /*Finally, the onTabSelectedListener is configured on the TabLayout instance
             and the onTabSelected() method implemented to set the current page on the ViewPager
              based on the currently selected tab number.*/

            tab_layout.addOnTabSelectedListener(object : TabLayout.
            OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab) {
                    pager.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                }

                override fun onTabReselected(tab: TabLayout.Tab) {
                }
            })
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

}
