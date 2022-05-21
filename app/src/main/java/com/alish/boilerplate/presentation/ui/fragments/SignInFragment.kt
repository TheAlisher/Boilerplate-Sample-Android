package com.alish.boilerplate.presentation.ui.fragments

import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.databinding.FragmentSignInBinding
import com.alish.boilerplate.domain.models.sign.UserSignIn
import com.alish.boilerplate.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment<SignInViewModel, FragmentSignInBinding>(
    R.layout.fragment_sign_in
) {

    override val viewModel: SignInViewModel by viewModels()
    override val binding by viewBinding(FragmentSignInBinding::bind)

    override fun setupListeners() {
        binding.buttonSignIn.setOnClickListener {
            // Код для примера в реалии все знаем какие данные сюда вбивать )
            viewModel.signIn(UserSignIn("Shield Hero", "Raphtalia"))
        }
    }

    override fun setupSubscribers() {
        viewModel.signInState.collectUIState(
            state = {
                // скрыть показать group и loader
                it.setupViewVisibility(binding.groupSignIn, binding.loaderSignIn, true)
            },
            onError = {
                // Отобразить ошибку
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                // Перейти на главную страницу
                navigate()
            }
        )
    }
}