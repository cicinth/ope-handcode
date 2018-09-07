package br.com.ope.security

import br.com.ope.exception.UsuarioInativoException
import br.com.ope.exception.UsuarioSemPermissoesException
import br.com.ope.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserDetailsServiceImpl(val usuarioRepository : UsuarioRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class, UsuarioInativoException::class)
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    override fun loadUserByUsername(email: String): UserDetails {

        val usuario = usuarioRepository.findOneWithPermissoesByEmail(email)

        if (!usuario.isPresent) throw UsernameNotFoundException(email)

        if (!usuario.get().isEnabled) throw UsuarioInativoException()

        if (usuario.get().permissoes.isEmpty()) throw UsuarioSemPermissoesException()

        //TODO(RETONRAR UM DTO PARA CADA TIPO DE USUARIO )

        return usuario.get()
    }

}