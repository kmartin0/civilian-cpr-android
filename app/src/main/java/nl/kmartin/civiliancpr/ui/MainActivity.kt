package nl.kmartin.civiliancpr.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import nl.kmartin.civiliancpr.R
import nl.kmartin.civiliancpr.databinding.ActivityMainBinding
import nl.kmartin.civiliancpr.repository.IMessageRepository
import nl.kmartin.civiliancpr.util.NotificationBuilder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var messageRepository: IMessageRepository

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        initViewBinding()
        initSystemBars()
        initNavFragment()
        checkSmsPermission()
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initSystemBars() {
        val initialToolbarHeight = binding.toolbar.layoutParams.height
        val initialToolbarPaddingTop = binding.toolbar.paddingTop
        val initialNavHostPaddingBottom = binding.navHostFragment.paddingBottom

        // The status bar is drawn over the primary-colored toolbar,
        // so its icons should use the light appearance.
        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = false

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
            val statusBars = windowInsets.getInsets(
                WindowInsetsCompat.Type.statusBars()
            )
            val navigationBars = windowInsets.getInsets(
                WindowInsetsCompat.Type.navigationBars()
            )

            // Extend the toolbar behind the status bar while keeping
            // its title below the system icons.
            binding.toolbar.updateLayoutParams {
                height = initialToolbarHeight + statusBars.top
            }

            binding.toolbar.updatePadding(
                top = initialToolbarPaddingTop + statusBars.top
            )

            // Keep fragment content above the navigation controls.
            binding.navHostFragment.updatePadding(
                bottom = initialNavHostPaddingBottom + navigationBars.bottom
            )

            windowInsets
        }

        ViewCompat.requestApplyInsets(binding.root)
    }

    /**
     * Checks if sms permissions have been granted.
     * Prompt popup to ask for permission if not granted.
     */
    private fun checkSmsPermission() {
        if (
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECEIVE_SMS
            ) == PackageManager.PERMISSION_DENIED
        ) {
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) {}.launch(Manifest.permission.RECEIVE_SMS)
        }
    }

    /**
     * Initialize the navigation graph with the toolbar and navigation fragment host.
     */
    private fun initNavFragment() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        findViewById<Toolbar>(R.id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)
    }

    /**
     * When the app is opened remove the notifications.
     */
    override fun onStart() {
        super.onStart()
        NotificationBuilder.cancelAllNotifications(this)
    }
}